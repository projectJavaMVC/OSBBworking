package ua.kiev.prog.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by m.bratyuk on 24.11.2015.
 */
@Entity
@Table(name = "flats", schema = "", catalog = "prog")
public class FlatsEntity {
    private int id;
    private Integer flatNumber;
    private Integer peopleCnt;
    private BigDecimal area;

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Flat_Number", nullable = true, insertable = true, updatable = true)
    public Integer getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(Integer flatNumber) {
        this.flatNumber = flatNumber;
    }

    @Basic
    @Column(name = "People_CNT", nullable = true, insertable = true, updatable = true)
    public Integer getPeopleCnt() {
        return peopleCnt;
    }

    public void setPeopleCnt(Integer peopleCnt) {
        this.peopleCnt = peopleCnt;
    }

    @Basic
    @Column(name = "Area", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlatsEntity that = (FlatsEntity) o;

        if (id != that.id) return false;
        if (area != null ? !area.equals(that.area) : that.area != null) return false;
        if (flatNumber != null ? !flatNumber.equals(that.flatNumber) : that.flatNumber != null) return false;
        if (peopleCnt != null ? !peopleCnt.equals(that.peopleCnt) : that.peopleCnt != null) return false;

        return true;
    }

    public FlatsEntity() {
    }

    public FlatsEntity(Integer flatNumber, Integer peopleCnt, BigDecimal area) {
        this.flatNumber = flatNumber;
        this.peopleCnt = peopleCnt;
        this.area = area;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (flatNumber != null ? flatNumber.hashCode() : 0);
        result = 31 * result + (peopleCnt != null ? peopleCnt.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
        return result;
    }
}
