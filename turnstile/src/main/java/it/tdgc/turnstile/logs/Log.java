package it.tdgc.turnstile.logs;

import java.util.Date;

import it.tdgc.turnstile.employee.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "log", schema="public")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_seq")
    @SequenceGenerator(name = "log_seq", sequenceName = "log_id_seq", allocationSize = 1)
    private long id;

    @Column(name="date", nullable= false)
    private Date date;

    @Column(name="enter_time", nullable= false)
    private Date enter_time;
    
    @Column(name="exit_time", nullable= false)
    private Date exit_time;
    

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;


    public Log(long id, Date date, Date enter_time, Date exit_time, Employee employee) {
        this.id = id;
        this.date = date;
        this.enter_time = enter_time;
        this.exit_time = exit_time;
        this.employee = employee;
    }

    public Log() {}

    /**
     * @return long return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return Date return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return Date return the enter_time
     */
    public Date getEnter_time() {
        return enter_time;
    }

    /**
     * @param enter_time the enter_time to set
     */
    public void setEnter_time(Date enter_time) {
        this.enter_time = enter_time;
    }

    /**
     * @return Date return the exit_time
     */
    public Date getExit_time() {
        return exit_time;
    }

    /**
     * @param exit_time the exit_time to set
     */
    public void setExit_time(Date exit_time) {
        this.exit_time = exit_time;
    }

    /**
     * @return Employee return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
