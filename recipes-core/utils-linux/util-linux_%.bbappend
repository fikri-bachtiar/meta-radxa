# Using the new file descriptors based mount kernel API can cause rootfs remount failure with some older kernels.
# Of currently supported LTS kernels, it seems safe to enable this option with:
# - version 6.6.18 and newer in the 6.6.y series.
# - version 6.1.79 and newer in the 6.1.y series.
# - with the 5.15.y series, versions till at least 5.15.164 can not use it.
# - with 5.10.y, 5.4.y and 4.19.y series kernels libmount seemed to use the old API regardless of this option.
PACKAGECONFIG[new-mount-api] = "--enable-libmount-mountfd-support,--disable-libmount-mountfd-support"