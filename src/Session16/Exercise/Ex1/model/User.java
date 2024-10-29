package Session16.Exercise.Ex1.model;

import java.sql.Date;

/**
 * The type User.
 */
public class User {
    private int id;
    private String name;
    private String address;
    private String phone;
    private Date dateOfBirth;
    private boolean role;
    private boolean status;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param id          the id
     * @param name        the name
     * @param address     the address
     * @param phone       the phone
     * @param dateOfBirth the date of birth
     * @param role        the role
     * @param status      the status
     */
    public User(int id, String name, String address, String phone, Date dateOfBirth, boolean role, boolean status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
        this.status = status;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone.
     *
     * @param phone the phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets date of birth.
     *
     * @return the date of birth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets date of birth.
     *
     * @param dateOfBirth the date of birth
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Is role boolean.
     *
     * @return the boolean
     */
    public boolean isRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(boolean role) {
        this.role = role;
    }

    /**
     * Is status boolean.
     *
     * @return the boolean
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", role=" + role +
                ", status=" + status +
                '}';
    }
}
