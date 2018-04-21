package cn.lvhaosir.entity;

import javax.persistence.*;

@Table(name = "weeks_text")
public class WeeksText {
    @Id
    @Column(name = "week_text_id")
    private Integer weekTextId;

    @Column(name = "room_id")
    private Integer roomId;

    private Byte study;

    private Byte health;

    @Column(name = "return_home")
    private Byte returnHome;

    @Column(name = "sleep_condition")
    private Byte sleepCondition;

    private Byte mood;

    private Byte consume;

    @Column(name = "love_lose")
    private Byte loveLose;

    @Column(name = "condition_text")
    private Byte conditionText;

    @Column(name = "teachers_return_text")
    private String teachersReturnText;

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "return_time")
    private String returnTime;

    /**
     * @return week_text_id
     */
    public Integer getWeekTextId() {
        return weekTextId;
    }

    /**
     * @param weekTextId
     */
    public void setWeekTextId(Integer weekTextId) {
        this.weekTextId = weekTextId;
    }

    /**
     * @return room_id
     */
    public Integer getRoomId() {
        return roomId;
    }

    /**
     * @param roomId
     */
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    /**
     * @return study
     */
    public Byte getStudy() {
        return study;
    }

    /**
     * @param study
     */
    public void setStudy(Byte study) {
        this.study = study;
    }

    /**
     * @return health
     */
    public Byte getHealth() {
        return health;
    }

    /**
     * @param health
     */
    public void setHealth(Byte health) {
        this.health = health;
    }

    /**
     * @return return_home
     */
    public Byte getReturnHome() {
        return returnHome;
    }

    /**
     * @param returnHome
     */
    public void setReturnHome(Byte returnHome) {
        this.returnHome = returnHome;
    }

    /**
     * @return sleep_condition
     */
    public Byte getSleepCondition() {
        return sleepCondition;
    }

    /**
     * @param sleepCondition
     */
    public void setSleepCondition(Byte sleepCondition) {
        this.sleepCondition = sleepCondition;
    }

    /**
     * @return mood
     */
    public Byte getMood() {
        return mood;
    }

    /**
     * @param mood
     */
    public void setMood(Byte mood) {
        this.mood = mood;
    }

    /**
     * @return consume
     */
    public Byte getConsume() {
        return consume;
    }

    /**
     * @param consume
     */
    public void setConsume(Byte consume) {
        this.consume = consume;
    }

    /**
     * @return love_lose
     */
    public Byte getLoveLose() {
        return loveLose;
    }

    /**
     * @param loveLose
     */
    public void setLoveLose(Byte loveLose) {
        this.loveLose = loveLose;
    }

    /**
     * @return condition_text
     */
    public Byte getConditionText() {
        return conditionText;
    }

    /**
     * @param conditionText
     */
    public void setConditionText(Byte conditionText) {
        this.conditionText = conditionText;
    }

    /**
     * @return teachers_return_text
     */
    public String getTeachersReturnText() {
        return teachersReturnText;
    }

    /**
     * @param teachersReturnText
     */
    public void setTeachersReturnText(String teachersReturnText) {
        this.teachersReturnText = teachersReturnText;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }
}