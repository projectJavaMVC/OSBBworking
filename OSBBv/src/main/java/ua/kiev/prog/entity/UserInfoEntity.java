package ua.kiev.prog.entity;

import javax.persistence.*;

/**
 * Created by m.bratyuk on 24.11.2015.
 */
@Entity
@Table(name = "user_info", schema = "", catalog = "prog")
public class UserInfoEntity {
    private int id;
    private String lastName;
    private String firstName;
    private String secondName;
    private String phone;
    private String flatNumber;
    private UserEntity userEntity;


    @OneToOne
    @JoinColumn(name="User_id", unique = true, nullable = false, updatable = true)
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }


    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Last_Name", nullable = true, insertable = true, updatable = true, length = 150)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "First_Name", nullable = true, insertable = true, updatable = true, length = 150)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "Second_Name", nullable = true, insertable = true, updatable = true, length = 150)
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "phone", nullable = true, insertable = true, updatable = true)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "flatNumber", nullable = true, insertable = true, updatable = true)
    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfoEntity that = (UserInfoEntity) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (secondName != null ? !secondName.equals(that.secondName) : that.secondName != null) return false;

        return true;
    }

    public UserInfoEntity() {
    }



    public UserInfoEntity(String firstName, String lastName,String secondName, String phone, String flatNum, UserEntity user) {
        this.lastName = lastName;
        this.phone = phone;
        this.secondName = secondName;
        this.firstName = firstName;
        this.flatNumber = flatNum;

        this.userEntity = user;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
