package connection;

import appenum.JobEnum;
import appenum.VisitTypeEnum;

import java.util.Map;

public class VisitTypeToJobConnection {

    private Map<VisitTypeEnum, JobEnum> visitTypeEnumToJobEnumConnectionMap;

    public Map<VisitTypeEnum, JobEnum> getVisitTypeEnumToJobEnumConnectionMap() {
        return visitTypeEnumToJobEnumConnectionMap;
    }

    public void setVisitTypeEnumToJobEnumConnectionMap(Map<VisitTypeEnum, JobEnum> visitTypeEnumToJobEnumConnectionMap) {
        this.visitTypeEnumToJobEnumConnectionMap = visitTypeEnumToJobEnumConnectionMap;
    }
}
