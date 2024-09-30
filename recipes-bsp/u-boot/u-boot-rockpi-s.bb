DEFAULT_PREFERENCE = "1"

DESCRIPTION = "RockPi-S U-Boot"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

include u-boot-rockpi.inc

SRC_URI = "git://github.com/radxa/u-boot;protocol=https;branch=stable-4.4-rockpis \
           file://0001-Use-local-command.h-file-instead-of-system-file.patch \
           file://0001-Makefile-disable-gcc9-s-address-of-packed-member-war.patch \
           file://${MACHINE}/boot.cmd \
           file://${MACHINE}/uEnv.txt \
           file://0002-rm-dont-compile-unused-dts.patch \
           file://0001-fix-compilation-error-with-gcc13.patch \
           "

SRCREV = "c93a0fc70993c12e605b1312577252ca9cdec6c8"

FILES:${PN} =" \
	boot/boot.scr \
	boot/u-boot-rockpi-s-rk3308-1.0-r0.bin \
	boot/u-boot.bin \
	boot/uEnv.txt \
"