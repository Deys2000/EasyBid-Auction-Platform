package com.company.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;

@Entity
@Table(name="shipment")
public class Shipment {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "item_id", nullable = false)
    private int itemId;
    @Column(name = "carrier", nullable = false)
    private String carrier;
    @Column(name = "shipping_time", nullable = false)
    private String shippingTime;
    @Column(name = "shipping_status", nullable = false)
    private String shippingStatus;

    
    public Shipment(){
        
    }

    public Shipment(int id, int itemId, String carrier, String shippingTime, String shippingStatus) {
        this.id = id;
        this.itemId = itemId;
        this.carrier = carrier;
        this.shippingTime = shippingTime;
        this.shippingStatus = shippingStatus;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public String getCarrier() {
        return carrier;
    }
    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
    public String getShippingTime() {
        return shippingTime;
    }
    public void setShippingTime(String shippingTime) {
        this.shippingTime = shippingTime;
    }
    public String getShippingStatus() {
        return shippingStatus;
    }
    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + itemId;
        result = prime * result + ((carrier == null) ? 0 : carrier.hashCode());
        result = prime * result + ((shippingTime == null) ? 0 : shippingTime.hashCode());
        result = prime * result + ((shippingStatus == null) ? 0 : shippingStatus.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Shipment other = (Shipment) obj;
        if (id != other.id)
            return false;
        if (itemId != other.itemId)
            return false;
        if (carrier == null) {
            if (other.carrier != null)
                return false;
        } else if (!carrier.equals(other.carrier))
            return false;
        if (shippingTime == null) {
            if (other.shippingTime != null)
                return false;
        } else if (!shippingTime.equals(other.shippingTime))
            return false;
        if (shippingStatus == null) {
            if (other.shippingStatus != null)
                return false;
        } else if (!shippingStatus.equals(other.shippingStatus))
            return false;
        return true;
    }    

}
