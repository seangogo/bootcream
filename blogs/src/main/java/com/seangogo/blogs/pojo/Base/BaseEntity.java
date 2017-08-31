package com.seangogo.blogs.pojo.Base;

import com.seangogo.blogs.pojo.auditable.ValidatorListener;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@MappedSuperclass
@EntityListeners({ ValidatorListener.class,AuditingEntityListener.class})
@Data
public abstract class BaseEntity<U> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键ID自动生成策略
     */
    @Id
    @GenericGenerator(name = "id", strategy = "uuid")
    @GeneratedValue(generator = "id")
    @Column(name = "id", length = 36)
    protected String id;

    @CreatedBy
    protected U createdBy;

    @CreatedDate
    @Temporal(TIMESTAMP)
    protected Date createdDate;

    @LastModifiedBy
    protected U lastModifiedBy;

    @LastModifiedDate
    @Temporal(TIMESTAMP)
    protected Date lastModifiedDate;

    /**
     * 删除标记(0启用，1禁用)
     */
    @Column(name = "deleted")
    private Integer deleted;

    /**
     * 版本号
     */
    @Version
    @Column(name = "version")
    protected Integer version;
}