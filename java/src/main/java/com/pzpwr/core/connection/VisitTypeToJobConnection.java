package com.pzpwr.core.connection;

import com.pzpwr.core.appenum.JobEnum;
import com.pzpwr.core.appenum.VisitTypeEnum;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;

import javax.annotation.PostConstruct;

@Component
public class VisitTypeToJobConnection {

    private Map<VisitTypeEnum, JobEnum> visitTypeEnumToJobEnumConnectionMap;

    public Map<VisitTypeEnum, JobEnum> getVisitTypeEnumToJobEnumConnectionMap() {
        return visitTypeEnumToJobEnumConnectionMap;
    }

    public void setVisitTypeEnumToJobEnumConnectionMap(Map<VisitTypeEnum, JobEnum> visitTypeEnumToJobEnumConnectionMap) {
        this.visitTypeEnumToJobEnumConnectionMap = visitTypeEnumToJobEnumConnectionMap;
    }
}
