package com.example.demo.model;


import java.util.Date;

public class User {
    private String userId;

    private String nickName;

    private String passwd;

    private String langCode;

    private String mobile;

    private String smallAvatarUrl;

    private String originalAvatarUrl;

    private String email;

    private String qrcodeString;

    private Byte gender;

    private Integer standing;

    private Byte userStatus;

    private String lastPhoneIMEI;

    private String lastPhoneBrand;

    private String lastPhoneModel;

    private String apnsToken;

    private Long dataVersion;

    private Date createTime;

	private String belongId;

	private Byte robotStatus;

	private String welcomeMessage;

	private String welcomeTips;

	private String remark;

	private Byte type;

	private int isOnline;

	public int getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(int isOnline) {
		this.isOnline = isOnline;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSmallAvatarUrl() {
		return smallAvatarUrl;
	}

	public void setSmallAvatarUrl(String smallAvatarUrl) {
		this.smallAvatarUrl = smallAvatarUrl;
	}

	public String getOriginalAvatarUrl() {
		return originalAvatarUrl;
	}

	public void setOriginalAvatarUrl(String originalAvatarUrl) {
		this.originalAvatarUrl = originalAvatarUrl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQrcodeString() {
		return qrcodeString;
	}

	public void setQrcodeString(String qrcodeString) {
		this.qrcodeString = qrcodeString;
	}

	public Byte getGender() {
		return gender;
	}

	public void setGender(Byte gender) {
		this.gender = gender;
	}

	public Integer getStanding() {
		return standing;
	}

	public void setStanding(Integer standing) {
		this.standing = standing;
	}

	public Byte getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Byte userStatus) {
		this.userStatus = userStatus;
	}

	public String getLastPhoneIMEI() {
		return lastPhoneIMEI;
	}

	public void setLastPhoneIMEI(String lastPhoneIMEI) {
		this.lastPhoneIMEI = lastPhoneIMEI;
	}

	public String getLastPhoneBrand() {
		return lastPhoneBrand;
	}

	public void setLastPhoneBrand(String lastPhoneBrand) {
		this.lastPhoneBrand = lastPhoneBrand;
	}

	public String getLastPhoneModel() {
		return lastPhoneModel;
	}

	public void setLastPhoneModel(String lastPhoneModel) {
		this.lastPhoneModel = lastPhoneModel;
	}

	public String getApnsToken() {
		return apnsToken;
	}

	public void setApnsToken(String apnsToken) {
		this.apnsToken = apnsToken;
	}

	public Long getDataVersion() {
		return dataVersion;
	}

	public void setDataVersion(Long dataVersion) {
		this.dataVersion = dataVersion;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getBelongId() {
		return belongId;
	}

	public void setBelongId(String belongId) {
		this.belongId = belongId;
	}

	public Byte getRobotStatus() {
		return robotStatus;
	}

	public void setRobotStatus(Byte robotStatus) {
		this.robotStatus = robotStatus;
	}

	public String getWelcomeMessage() {
		return welcomeMessage;
	}

	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}

	public String getWelcomeTips() {
		return welcomeTips;
	}

	public void setWelcomeTips(String welcomeTips) {
		this.welcomeTips = welcomeTips;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", nickName=" + nickName + ", passwd=" + passwd + ", langCode=" + langCode
				+ ", mobile=" + mobile + ", smallAvatarUrl=" + smallAvatarUrl + ", originalAvatarUrl="
				+ originalAvatarUrl + ", email=" + email + ", type=" + type +", qrcodeString=" + qrcodeString + ", gender=" + gender
				+ ", standing=" + standing + ", userStatus=" + userStatus + ", lastPhoneIMEI=" + lastPhoneIMEI
				+ ", lastPhoneBrand=" + lastPhoneBrand + ", lastPhoneModel=" + lastPhoneModel + ", apnsToken="
				+ apnsToken + ", dataVersion=" + dataVersion + ", createTime=" + createTime + "]";
	}
	
    
}