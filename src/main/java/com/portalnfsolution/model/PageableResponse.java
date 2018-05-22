package com.portalnfsolution.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.portalnfsolution.util.CustomSortDeserializer;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felipe.simmi on 20/10/2017.
 */
public class PageableResponse<T> extends PageImpl<T> {

    private boolean last;
    private boolean first;
    private int totalPages;

    public PageableResponse(@JsonProperty("content") List content,
                            @JsonProperty("number") int page,
                            @JsonProperty("size") int size,
                            @JsonProperty("totalElements") long totalElements,
                            @JsonProperty("sort") @JsonDeserialize(using = CustomSortDeserializer.class) Sort sort) {
        super(content, new PageRequest(page, size, sort), totalElements);
    }

    public PageableResponse() {
        super(new ArrayList());
    }

    @Override
    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    @Override
    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    @Override
    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
