package com.smart.app.weighing.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Setter(value = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@MappedSuperclass
@JsonIgnoreProperties(
        value = {"created_by", "createdDate", "last_modified_by", "last_modified_date"},
        allowGetters = true
)
@EntityListeners(AuditingEntityListener.class)
public class Auditable<U> extends Identifier {

	private static final long serialVersionUID = 6985483892065585553L;

	@CreatedBy
    @Column(name = "created_by")
    private U createdBy;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    private U lastModifiedBy;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;
    
}
