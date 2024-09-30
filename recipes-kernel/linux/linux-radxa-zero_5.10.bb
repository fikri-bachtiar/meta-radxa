DESCRIPTION = "Linux kernel for Radxa Zero"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = " \
	git://github.com/radxa/kernel;protocol=https;branch=linux-5.10.y-radxa-zero \
"

SRCREV = "57a25a2f2f476f98a9a98115853b29f10b086f77"
LINUX_VERSION = "5.10.69"

# Override local version in order to use the one generated by linux build system
# And not "yocto-standard"
LINUX_VERSION_EXTENSION = ""
PR = "r1"
PV = "${LINUX_VERSION}"

COMPATIBLE_MACHINE = "(s905y2)"

KCONFIG_MODE = "--alldefconfig"

# We need mkimage for the overlays
DEPENDS += "u-boot-mkimage-radxa-native"

do_compile:append() {
	oe_runmake dtbs
}

do_install:append() {
	install -d ${D}/boot/overlays
	install -m 644 ${B}/arch/arm64/boot/dts/amlogic/overlay/* ${D}/boot/overlays
}

do_deploy:append() {
	install -d ${DEPLOYDIR}/overlays
	install -m 644 ${B}/arch/arm64/boot/dts/amlogic/overlay/* ${DEPLOYDIR}/overlays
}

PACKAGES += "${PN}-overlays"
FILES_${PN}-overlays = "/boot/overlays/*"
