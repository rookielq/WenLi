package cn.lvhaosir.entity;

import javax.persistence.*;

@Table(name = "builds")
public class Builds {
    @Id
    @Column(name = "build_id")
    private Integer buildId;

    @Column(name = "build_name")
    private String buildName;

    @Column(name = "build_max_layer")
    private Byte buildMaxLayer;

    /**
     * @return build_id
     */
    public Integer getBuildId() {
        return buildId;
    }

    /**
     * @param buildId
     */
    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    /**
     * @return build_name
     */
    public String getBuildName() {
        return buildName;
    }

    /**
     * @param buildName
     */
    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    /**
     * @return build_max_layer
     */
    public Byte getBuildMaxLayer() {
        return buildMaxLayer;
    }

    /**
     * @param buildMaxLayer
     */
    public void setBuildMaxLayer(Byte buildMaxLayer) {
        this.buildMaxLayer = buildMaxLayer;
    }
}