/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Foxxy
 */
public class Slot {
    private int slotId ;
    private String slotName ;
    private Date startName ;
    private Date endTime ;

    public Slot() {
    }

    public Slot(int slotId, String slotName, Date startName, Date endTime) {
        this.slotId = slotId;
        this.slotName = slotName;
        this.startName = startName;
        this.endTime = endTime;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public String getSlotName() {
        return slotName;
    }

    public void setSlotName(String slotName) {
        this.slotName = slotName;
    }

    public Date getStartName() {
        return startName;
    }

    public void setStartName(Date startName) {
        this.startName = startName;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Slot{" + "slotId=" + slotId + ", slotName=" + slotName + ", startName=" + startName + ", endTime=" + endTime + '}';
    }
    
}
