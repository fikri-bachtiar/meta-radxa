# Copyright (C) 2019, Fuzhou Rockchip Electronics Co., Ltd

SUMMARY = "Rockchip WIFI/BT firmware files"
SECTION = "kernel"

# LICENSE = "Apache-2.0"
# LIC_FILES:CHKSUM = "file://NOTICE;md5=9645f39e9db895a4aa6e02cb57294595"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRCREV = "3277c78514fce8964c25172a5e8c7102bd0c17f6"
SRC_URI = "git://github.com/radxa/rkwifibt;protocol=https;branch=master"

SRC_URI[sha256sum] = "c61fb870c28605516dbb2f053e6d2ee7cd8a660bbb1405bc3a19730e01d7040b"

S = "${WORKDIR}/git"

inherit allarch deploy

do_install() {
	install -d ${D}/${nonarch_base_libdir}/firmware/brcm/
	install -m 0644 ${S}/firmware/broadcom/AW-NB197/bt/BCM4343A1_001.002.009.1008.1024.hcd \
		${D}/${nonarch_base_libdir}/firmware/brcm/bcm43438a1.hcd
	install -m 0644 ${S}/firmware/broadcom/AP6236/*/* \
		-t ${D}/${nonarch_base_libdir}/firmware/brcm/
	install -m 0644 ${S}/firmware/broadcom/AP6255/*/* \
		-t ${D}/${nonarch_base_libdir}/firmware/brcm/
	install -m 0644 ${S}/firmware/broadcom/AP6256/bt/* \
		-t ${D}/${nonarch_base_libdir}/firmware/brcm/
	install -m 0644 ${S}/firmware/broadcom/AP6256/wifi/fw_bcm43456c5_ag.bin \
		${D}/${nonarch_base_libdir}/firmware/brcm/brcmfmac43456-sdio.bin
	install -m 0644 ${S}/firmware/broadcom/AP6256/wifi/nvram_ap6256.txt \
		${D}/${nonarch_base_libdir}/firmware/brcm/brcmfmac43456-sdio.txt
	install -m 0644 ${S}/firmware/broadcom/AP6356/*/* \
		-t ${D}/${nonarch_base_libdir}/firmware/brcm/
	install -m 0644 ${S}/firmware/broadcom/AP6398S/*/* \
		-t ${D}/${nonarch_base_libdir}/firmware/brcm/

	# let's use the firmware for AP6212 from Infineon / Cypress
	install -m 0644 ${S}/firmware/cypress/wifi/cyfmac43430-sdio.bin ${D}/${nonarch_base_libdir}/firmware/brcm/brcmfmac43430-sdio.bin
	install -m 0644 ${S}/firmware/cypress/wifi/cyfmac43430-sdio.txt ${D}/${nonarch_base_libdir}/firmware/brcm/brcmfmac43430-sdio.txt
	install -m 0644 ${S}/firmware/cypress/wifi/cyfmac43430-sdio.clm_blob ${D}/${nonarch_base_libdir}/firmware/brcm/brcmfmac43430-sdio.clm_blob

	install -d ${D}${base_libdir}/firmware/rtlbt/
	install -m 0644 ${S}/realtek/RTL8723DS/* -t ${D}${base_libdir}/firmware/rtlbt/
	install -m 0644 ${S}/realtek/RTL8723DU/* -t ${D}${base_libdir}/firmware/
	install -m 0644 ${S}/realtek/RTL8821CU/* -t ${D}${base_libdir}/firmware/
}

PACKAGES =+ " \
	${PN}-ap6212a1-wifi \
	${PN}-ap6212a1-bt \
	${PN}-ap6236-wifi \
	${PN}-ap6236-bt \
	${PN}-ap6255-wifi \
	${PN}-ap6255-bt \
	${PN}-ap6256-wifi \
	${PN}-ap6256-bt \
	${PN}-ap6356-wifi \
	${PN}-ap6356-bt \
	${PN}-ap6398s-wifi \
	${PN}-ap6398s-bt \
	${PN}-rtl8723ds-bt \
	${PN}-rtl8723du-bt \
	${PN}-rtl8821cu-bt \
"

FILES:${PN}-ap6212a1-wifi = " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac43430-sdio* \
"

FILES:${PN}-ap6212a1-bt = " \
	${nonarch_base_libdir}/firmware/brcm/bcm43438a1.hcd \
"

FILES:${PN}-ap6236-wifi = " \
	${nonarch_base_libdir}/firmware/brcm/fw_bcm43436b0.bin \
	${nonarch_base_libdir}/firmware/brcm/nvram_ap6236.txt \
"

FILES:${PN}-ap6236-bt = " \
	${nonarch_base_libdir}/firmware/brcm/BCM4343B0.hcd \
"

FILES:${PN}-ap6255-wifi = " \
	${nonarch_base_libdir}/firmware/brcm/fw_bcm43455c0_ag.bin \
	${nonarch_base_libdir}/firmware/brcm/fw_bcm43455c0_ag_p2p.bin \
	${nonarch_base_libdir}/firmware/brcm/nvram_ap6255.txt \
"

FILES:${PN}-ap6255-bt = " \
	${nonarch_base_libdir}/firmware/brcm/BCM4345C0.hcd \
"

FILES:${PN}-ap6256-wifi = " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac43456-sdio* \
"

FILES:${PN}-ap6256-bt = " \
	${nonarch_base_libdir}/firmware/brcm/BCM4345C5.hcd \
"

FILES:${PN}-ap6356-wifi = " \
	${nonarch_base_libdir}/firmware/brcm/fw_bcm4356a2_ag.bin \
	${nonarch_base_libdir}/firmware/brcm/nvram_ap6356.txt \
"

FILES:${PN}-ap6356-bt = " \
	${nonarch_base_libdir}/firmware/brcm/BCM4356A2.hcd \
"

FILES:${PN}-ap6398s-wifi = " \
	${nonarch_base_libdir}/firmware/brcm/fw_bcm4359c0_ag.bin \
	${nonarch_base_libdir}/firmware/brcm/fw_bcm4359c0_ag_p2p.bin \
	${nonarch_base_libdir}/firmware/brcm/nvram_ap6398s.txt \
"

FILES:${PN}-ap6398s-bt = " \
	${nonarch_base_libdir}/firmware/brcm/BCM4359C0.hcd \
"

FILES:${PN}-rtl8723ds-bt = " \
	${base_libdir}/firmware/rtlbt/rtl8723d_config \
	${base_libdir}/firmware/rtlbt/rtl8723d_fw \
"

FILES:${PN}-rtl8723du-bt = " \
	${base_libdir}/firmware/rtl8723du_config \
	${base_libdir}/firmware/rtl8723du_fw \
"

FILES:${PN}-rtl8821cu-bt = " \
	${base_libdir}/firmware/rtl8821cu_config \
	${base_libdir}/firmware/rtl8821cu_fw \
"

FILES:${PN} = "*"

# Make it depend on all of the split-out packages.
python () {
    pn = d.getVar('PN')
    firmware_pkgs = oe.utils.packages_filter_out_system(d)
    d.appendVar('RDEPENDS_' + pn, ' ' + ' '.join(firmware_pkgs))
}

INSANE_SKIP_${PN} += "arch"
