package calendar.storage;

import calendar.type.Visit;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Storage {

    private List<Visit> visitList = new ArrayList<>();

    public void setData(List<Visit> visitList) {
        this.visitList = visitList;
    }

    public List<Visit> getVisitList() {
        return visitList;
    }
}