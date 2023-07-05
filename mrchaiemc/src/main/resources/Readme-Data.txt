#前端请求数据说明-not null
#Base 请求包
{
    version：前端版本号,
    language:"en" ,-- en zh_CN  zh_TW
    userprofile:"simple" --  simple/adavance
    actionCode:"login"/"register"/"opr"
}
#userLogin
userLogin.do
{
	"custId": "1111",
	"bussData": {
		"identityType": "PASSWD",
		"authToken": "0xa89981988ba"
	}
}
#userRegAppl
applyRegister.do
{
	"actionCode": "register",
	"bussData": {
		"applRegInfo": "{\"loginId\":\"yangsenessa1\",\"email\":\"yangsenessa@gmail.com\",\"mobilePhone\": \"138888888888\",\"nickName\": \"barry\"}"
	}
}
#setOrUpdateAuthToken
setAutoration.do
{
    "actionCode":"setToken",
    "custId":"1685969357974",
    "bussData":{
    "identityType":"PASSWD",
    "authToken":"123456"
    }
}

#addModel
addNewModel.do
{
	"custId": "1111",
	"bussData": {
		"modelInfo": "{\"modelName\":\"myfirst model\",\"modelSubName\":\"myfirst model sub name\",\"category1\":\"LORA\"}"
	}
}
#-------response
{
    "resultCode": "SUCCESS",
    "gmtDate": 1688404429748,
    "loginStatus": "true",
    "bussData": {
        "model_id": "77b35362-8914-420b-8648-51c221857d5d"
    }
}