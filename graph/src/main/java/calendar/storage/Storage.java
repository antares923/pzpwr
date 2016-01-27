package calendar.storage;

import calendar.type.Visit;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private boolean changed = false;

    private List<Visit> visitList = new ArrayList<>();

    public void setData(List<Visit> visitList) {
        this.visitList = visitList;
    }

    public List<Visit> getVisitList() {
        return visitList;
    }

    public boolean hasChanged() {
        return changed;
    }

    public void changed() {
        changed = true;
    }

    public void changeDone() {
        changed = false;
    }
}