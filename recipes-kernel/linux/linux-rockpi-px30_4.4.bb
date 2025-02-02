DESCRIPTION = "Linux kernel for RockPi-PX30"

require recipes-kernel/linux/linux-yocto.inc

# We need mkimage for the overlays
DEPENDS += "openssl-native u-boot-mkimage-radxa-native"

do_compile[depends] += "u-boot-mkimage-radxa-native:do_populate_sysroot"

SRC_URI = " \
	git://github.com/radxa/kernel.git;branch=stable-4.4-px30; \
	file://0002-Suppress-additional-warnings.patch \
"

SRCREV = "dc47906e88166ae315f0472743de4d80f2bea786"
LINUX_VERSION = "4.4.189"

# Override local version in order to use the one generated by linux build system
# And not "yocto-standard"
LINUX_VERSION_EXTENSION = ""
PR = "r1"
PV = "${LINUX_VERSION}"

# Include only supported boards for now
COMPATIBLE_MACHINE = "(px30|rk3036|rk3066|rk3288|rk3328|rk3399|rk3308)"
deltask kernel_configme

do_compile_append() {
	oe_runmake dtbs
}

do_deploy_append() {
#	install -d ${DEPLOYDIR}/overlays
#	install -m 644 ${WORKDIR}/linux-rockpi_px30-standard-build/arch/arm64/boot/dts/rockchip/overlay/* ${DEPLOYDIR}/overlays
}

