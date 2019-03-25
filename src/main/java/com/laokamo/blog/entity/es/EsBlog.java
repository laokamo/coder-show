package com.laokamo.blog.entity.es;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * EsBlog 对象
 */
@Data
@Document(indexName = "blog",type = "blog")
public class EsBlog implements Serializable {

    @Id
    private String id;

    private String title;

    private String summary;

    private String content;


}
