package com.liuche.wiki.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * 电子书快照表(EbookSnapshot)实体类
 *
 * @author makejava
 * @since 2023-03-20 15:09:27
 */
public class EbookSnapshot implements Serializable {
    private static final long serialVersionUID = -10752898233604401L;
    /**
     * id
     */
    private Long id;
    /**
     * 电子书id
     */
    private Long ebookId;
    /**
     * 快照日期
     */
    private Date date;
    /**
     * 阅读数
     */
    private Integer viewCount;
    /**
     * 点赞数
     */
    private Integer voteCount;
    /**
     * 阅读增长
     */
    private Integer viewIncrease;
    /**
     * 点赞增长
     */
    private Integer voteIncrease;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEbookId() {
        return ebookId;
    }

    public void setEbookId(Long ebookId) {
        this.ebookId = ebookId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Integer getViewIncrease() {
        return viewIncrease;
    }

    public void setViewIncrease(Integer viewIncrease) {
        this.viewIncrease = viewIncrease;
    }

    public Integer getVoteIncrease() {
        return voteIncrease;
    }

    public void setVoteIncrease(Integer voteIncrease) {
        this.voteIncrease = voteIncrease;
    }

    @Override
    public String toString() {
        return "EbookSnapshot{" +
                "id=" + id +
                ", ebookId=" + ebookId +
                ", date=" + date +
                ", viewCount=" + viewCount +
                ", voteCount=" + voteCount +
                ", viewIncrease=" + viewIncrease +
                ", voteIncrease=" + voteIncrease +
                '}';
    }
}

