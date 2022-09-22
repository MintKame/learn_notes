// dllmain.h: 模块类的声明。

class Clab2Module : public ATL::CAtlDllModuleT< Clab2Module >
{
public :
	DECLARE_LIBID(LIBID_lab2Lib)
	DECLARE_REGISTRY_APPID_RESOURCEID(IDR_LAB2, "{961d92d2-5acd-46a3-b991-1939852b76f5}")
};

extern class Clab2Module _AtlModule;
