/*
 * This file is generated by jOOQ.
*/
package stroom.db.auth.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;

import stroom.db.auth.tables.Users;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsersRecord extends UpdatableRecordImpl<UsersRecord> implements Record9<Integer, String, Timestamp, String, Integer, Timestamp, String, Timestamp, String> {

    private static final long serialVersionUID = -147267176;

    /**
     * Setter for <code>auth.users.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>auth.users.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>auth.users.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>auth.users.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>auth.users.last_login</code>.
     */
    public void setLastLogin(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>auth.users.last_login</code>.
     */
    public Timestamp getLastLogin() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>auth.users.password_hash</code>.
     */
    public void setPasswordHash(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>auth.users.password_hash</code>.
     */
    public String getPasswordHash() {
        return (String) get(3);
    }

    /**
     * Setter for <code>auth.users.total_login_failures</code>.
     */
    public void setTotalLoginFailures(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>auth.users.total_login_failures</code>.
     */
    public Integer getTotalLoginFailures() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>auth.users.created_on</code>.
     */
    public void setCreatedOn(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>auth.users.created_on</code>.
     */
    public Timestamp getCreatedOn() {
        return (Timestamp) get(5);
    }

    /**
     * Setter for <code>auth.users.created_by_user</code>.
     */
    public void setCreatedByUser(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>auth.users.created_by_user</code>.
     */
    public String getCreatedByUser() {
        return (String) get(6);
    }

    /**
     * Setter for <code>auth.users.updated_on</code>.
     */
    public void setUpdatedOn(Timestamp value) {
        set(7, value);
    }

    /**
     * Getter for <code>auth.users.updated_on</code>.
     */
    public Timestamp getUpdatedOn() {
        return (Timestamp) get(7);
    }

    /**
     * Setter for <code>auth.users.updated_by_user</code>.
     */
    public void setUpdatedByUser(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>auth.users.updated_by_user</code>.
     */
    public String getUpdatedByUser() {
        return (String) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Integer, String, Timestamp, String, Integer, Timestamp, String, Timestamp, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Integer, String, Timestamp, String, Integer, Timestamp, String, Timestamp, String> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Users.USERS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Users.USERS.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return Users.USERS.LAST_LOGIN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Users.USERS.PASSWORD_HASH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return Users.USERS.TOTAL_LOGIN_FAILURES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field6() {
        return Users.USERS.CREATED_ON;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Users.USERS.CREATED_BY_USER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field8() {
        return Users.USERS.UPDATED_ON;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return Users.USERS.UPDATED_BY_USER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value3() {
        return getLastLogin();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getPasswordHash();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getTotalLoginFailures();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value6() {
        return getCreatedOn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getCreatedByUser();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value8() {
        return getUpdatedOn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getUpdatedByUser();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value3(Timestamp value) {
        setLastLogin(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value4(String value) {
        setPasswordHash(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value5(Integer value) {
        setTotalLoginFailures(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value6(Timestamp value) {
        setCreatedOn(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value7(String value) {
        setCreatedByUser(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value8(Timestamp value) {
        setUpdatedOn(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value9(String value) {
        setUpdatedByUser(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord values(Integer value1, String value2, Timestamp value3, String value4, Integer value5, Timestamp value6, String value7, Timestamp value8, String value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsersRecord
     */
    public UsersRecord() {
        super(Users.USERS);
    }

    /**
     * Create a detached, initialised UsersRecord
     */
    public UsersRecord(Integer id, String name, Timestamp lastLogin, String passwordHash, Integer totalLoginFailures, Timestamp createdOn, String createdByUser, Timestamp updatedOn, String updatedByUser) {
        super(Users.USERS);

        set(0, id);
        set(1, name);
        set(2, lastLogin);
        set(3, passwordHash);
        set(4, totalLoginFailures);
        set(5, createdOn);
        set(6, createdByUser);
        set(7, updatedOn);
        set(8, updatedByUser);
    }
}