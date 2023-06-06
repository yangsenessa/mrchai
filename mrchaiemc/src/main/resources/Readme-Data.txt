#前端请求数据说明-not null
#Base 请求包
{
    version：前端版本号,
    language:"en" ,-- en zh_CN  zh_TW
    userprofile:"simple" --  simple/adavance
    actionCode:"login"/"register"/"opr"
}
#userLogin
{
	"custId": "1111",
	"bussData": {
		"identityType": "PASSWD",
		"authToken": "0xa89981988ba"
	}
}
#userRegAppl