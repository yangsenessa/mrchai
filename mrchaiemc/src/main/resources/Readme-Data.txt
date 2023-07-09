#前端请求数据说明-not null
#Base 请求包
{
    version：前端版本号,
    language:"en" ,-- en zh_CN  zh_TW
    userprofile:"simple" --  simple/adavance
    actionCode:"login"/"register"/"opr"
}
#userLogin 用户登录
userLogin.do
{
	"custId": "1111",
	"bussData": {
		"identityType": "PASSWD",
		"authToken": "0xa89981988ba"
	}
}
#userRegAppl 用户注册
applyRegister.do
{
	"actionCode": "register",
	"bussData": {
		"applRegInfo": "{\"loginId\":\"yangsenessa1\",\"email\":\"yangsenessa@gmail.com\",\"mobilePhone\": \"138888888888\",\"nickName\": \"barry\"}"
	}
}
#setOrUpdateAuthToken 用户修改鉴权-密码
setAutoration.do
{
    "actionCode":"setToken",
    "custId":"1685969357974",
    "bussData":{
    "identityType":"PASSWD",
    "authToken":"123456"
    }
}

#addModel 新增模型
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

#modModelDetailInfo.do 修改模型详情
{
	"custId": "1111",
	"bussData": {
		"modelDetail": "{\"modelId\": \"77b35362-8914-420b-8648-51c221857d5d\",\"version\": \"0.01\",\"downloadLink\": \"https://github.com/yangsenessa/mrchai/tree/emchubV0.0.1\",\"guideLink\": \"https://github.com/yangsenessa/mrchai/tree/emchubV0.0.1\",\"paramsGuideLink\": \"https://github.com/yangsenessa/mrchai/tree/emchubV0.0.1\",\"sampleCodeLink\": \"https://github.com/yangsenessa/mrchai/tree/emchubV0.0.1\",\"invokeGuide\": \"NOTICE:LET ME KNOW before you put this model on commercial usage. My twitter account:@eagelaxis :) Contact me if needed.Discord Account:Eagelaxis#7818Version Choosing Advice:V2f,V3,Coda and V3.5 are recommended,especially CODA for first-time users.Hard to tell how many models used to merge.Check the example images to recognize this model's art styleFor more example images, just take a look at https://pixai.art\",\"negativePromts\": \"1 corneo_power, bedroom, cute face, detailed body, detailed face, (sharp_teeth:0.8), +_+, pink panties, kids panties, home white t-shirt <lyco:GoodHands-beta2:1.0>\",\"positivePromts\": \"blurry, ugly, bad anatomy, extra limbs, undersaturated, low resolution, disfigured, deformations, out of frame, amputee, bad proportions, extra limb, missing limbs, distortion, floating limbs, out of frame, poorly drawn face, poorly drawn hands, text, malformed, missing fingers, cropped, wrong colour of clothes, wrong fingers\",\"commonParams\": \"Steps: 85, Size: 576x1024, Seed: 3172589486, Model: darkSushiMixMix_225D, Sampler: DPM++ SDE Karras, CFG scale: 8, Model hash: cca17b08da, Variation seed: 741382554, Variation seed strength: 0.15\"}"
	}
}

#----response
{
	"custId": "1111",
	"bussData": {
		"modelDetail": "{\"modelId\": \"77b35362-8914-420b-8648-51c221857d5d\",\"version\": \"0.01\",\"downloadLink\": \"https://github.com/yangsenessa/mrchai/tree/emchubV0.0.1\",\"guideLink\": \"https://github.com/yangsenessa/mrchai/tree/emchubV0.0.1\",\"paramsGuideLink\": \"https://github.com/yangsenessa/mrchai/tree/emchubV0.0.1\",\"sampleCodeLink\": \"https://github.com/yangsenessa/mrchai/tree/emchubV0.0.1\",\"invokeGuide\": \"NOTICE:LET ME KNOW before you put this model on commercial usage. My twitter account:@eagelaxis :) Contact me if needed.Discord Account:Eagelaxis#7818Version Choosing Advice:V2f,V3,Coda and V3.5 are recommended,especially CODA for first-time users.Hard to tell how many models used to merge.Check the example images to recognize this model's art styleFor more example images, just take a look at https://pixai.art\",\"negativePromts\": \"1 corneo_power, bedroom, cute face, detailed body, detailed face, (sharp_teeth:0.8), +_+, pink panties, kids panties, home white t-shirt <lyco:GoodHands-beta2:1.0>\",\"positivePromts\": \"blurry, ugly, bad anatomy, extra limbs, undersaturated, low resolution, disfigured, deformations, out of frame, amputee, bad proportions, extra limb, missing limbs, distortion, floating limbs, out of frame, poorly drawn face, poorly drawn hands, text, malformed, missing fingers, cropped, wrong colour of clothes, wrong fingers\",\"commonParams\": \"Steps: 85, Size: 576x1024, Seed: 3172589486, Model: darkSushiMixMix_225D, Sampler: DPM++ SDE Karras, CFG scale: 8, Model hash: cca17b08da, Variation seed: 741382554, Variation seed strength: 0.15\"}"
	}
}

#queryModelInfoForMainView.do 首页查询详情列表
{
    "custId":"1111",
    "bussData" :{
        pageIndex:0,
        pageSize:10
    }
}
# --response
{
    "resultCode": "SUCCESS",
    "gmtDate": 1688826163641,
    "loginStatus": "true",
    "bussData": {
        "modelList": "[{\"cateGory1\":\"LORA\",\"modelId\":\"77b35362-8914-420b-8648-51c221857d5d\",\"modelName\":\"myfirst model\",\"modelSubName\":\"myfirst model sub name\"}]"
    }
}

#queryModelDetailInfo.do 查询模型详情
{
    "custId":"1111",
    "bussData": {
        "model_id":"77b35362-8914-420b-8648-51c221857d5d"
    }
}
#--response
{
    "resultCode": "SUCCESS",
    "gmtDate": 1688868601357,
    "loginStatus": "true",
    "bussData": {
        "modelDetail": "{\"commonParams\":\"\\\"Steps: 85, Size: 576x1024, Seed: 3172589486, Model: darkSushiMixMix_225D, Sampler: DPM++ SDE Karras, CFG scale: 8, Model hash: cca17b08da, Variation seed: 741382554, Variation seed strength: 0.15\\\"\",\"downLoadLink\":\"https://github.com/yangsenessa/mrchai/tree/emchubV0.0.1\",\"guideLink\":\"https://github.com/yangsenessa/mrchai/tree/emchubV0.0.1\",\"invokeGuide\":\"NOTICE:LET ME KNOW before you put this model on commercial usage. My twitter account:@eagelaxis :) Contact me if needed.Discord Account:Eagelaxis#7818Version Choosing Advice:V2f,V3,Coda and V3.5 are recommended,especially CODA for first-time users.Hard to tell how many models used to merge.Check the example images to recognize this model's art styleFor more example images, just take a look at https://pixai.art\",\"modelId\":\"77b35362-8914-420b-8648-51c221857d5d\",\"negativePromts\":\"\\\"1 corneo_power, bedroom, cute face, detailed body, detailed face, (sharp_teeth:0.8), +_+, pink panties, kids panties, home white t-shirt <lyco:GoodHands-beta2:1.0>\\\"\",\"paramsGuideLink\":\"https://github.com/yangsenessa/mrchai/tree/emchubV0.0.1\",\"positivePromts\":\"\\\"blurry, ugly, bad anatomy, extra limbs, undersaturated, low resolution, disfigured, deformations, out of frame, amputee, bad proportions, extra limb, missing limbs, distortion, floating limbs, out of frame, poorly drawn face, poorly drawn hands, text, malformed, missing fingers, cropped, wrong colour of clothes, wrong fingers\\\"\",\"sampleCodeLink\":\"https://github.com/yangsenessa/mrchai/tree/emchubV0.0.1\",\"version\":\"0.01\"}"
    }
}