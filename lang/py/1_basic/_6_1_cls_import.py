# import entire module (recommand)
import _6_0_cls as cls_
# use: module_name.ClsName.xxx
# +: no conflict

# import single cls
from _6_0_cls import User as U
from _6_0_cls import *  # (not use) import all cls in a module
# use: ClsName.xxx


# init & visit --------------------------------------------------------------

# how to visit attr / method ?
# use "self" in inside the cls /
# use instance_name out the cls

yz = cls_.User("Yan", "zhao")
# auto invoke __init__, and auto pass self's ref

yz.print_info()
