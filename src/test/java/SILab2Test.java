import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SILab2Test {

    @Test
    public void shouldThrowExceptionIfHoursSmallerThanMinimum() {
        Time time = new Time(-4,11,21);
        List<Time> TimesList = new ArrayList<>();
        TimesList.add(time);
        try {
            SILab2.function(TimesList);
        } catch (Exception e){
            Assertions.assertEquals(e.getMessage(),"The hours are smaller than the minimum");
        }
    }

    @Test
    public void shouldThrowExceptionIfHoursAreGreaterThanOneDayMax() {
        Time Time = new Time(25,11,20);
        List<Time> TimesList = new ArrayList<>();
        TimesList.add(Time);
        try {
            SILab2.function(TimesList);
        } catch (Exception e){
            Assertions.assertEquals(e.getMessage(),"The hours are grater than the maximum");
        }
    }

    @Test
    public void shouldThrowExceptionIfMinutesAreInvalid() {
        Time Time = new Time(13,-13,25);
        Time Time2 = new Time(13,85,-3);
        List<Time> TimesList = new ArrayList<>();
        TimesList.add(Time);
        TimesList.add(Time2);
        try {
            SILab2.function(TimesList);
        } catch (Exception e){
            Assertions.assertEquals(e.getMessage(),"The minutes are not valid!");
        }
    }

    @Test
    public void shouldSetTheValuesProperlyIfInputDataIsValid() {
        Time Time = new Time(14,12,21);
        List<Time> TimesList = new ArrayList<>();
        List<Integer> result;
        TimesList.add(Time);
        result = SILab2.function(TimesList);
        Assertions.assertEquals(result.get(0).intValue(),Time.getHours()*3600 + Time.getMinutes()*60 + Time.getSeconds());
    }

    @Test
    public void ShouldThrowExceptionIfSecondsAreNotValid() {
        Time Time = new Time(14,23,99);
        Time Time2 = new Time(14,20,-33);
        List<Time> TimesList = new ArrayList<>();
        TimesList.add(Time);
        TimesList.add(Time2);
        try {
            SILab2.function(TimesList);
        } catch (Exception e){
            Assertions.assertEquals(e.getMessage(),"The seconds are not valid");
        }
    }

    @Test
    public void oneFullDayWithoutAnyExtraMinuteOrSecondsShouldBeValid() {
        Time Time = new Time(24,0,0);
        List<Time> TimesList = new ArrayList<>();
        List<Integer> result;
        TimesList.add(Time);
        result = SILab2.function(TimesList);
        Assertions.assertEquals(result.get(0).intValue(),Time.getHours()*3600 + Time.getMinutes()*60 + Time.getSeconds());
    }

    @Test
    public void shouldThrowExceptionIfDataExceedsOneFullDay() {
        Time Time = new Time(24,12,0);
        Time Time2 = new Time(24,0,13);
        List<Time> TimesList = new ArrayList<>();
        TimesList.add(Time);
        TimesList.add(Time2);
        try {
            SILab2.function(TimesList);
        } catch (Exception e){
            Assertions.assertEquals(e.getMessage(),"The time is greater than the maximum");
        }
    }

    @Test
    public void IfNoTimeSetItShouldBeEqualToZero() {
        List<Time> TimesList = new ArrayList<>();
        List<Integer> result;
        result = SILab2.function(TimesList);
        Assertions.assertEquals(result.size(),0);
    }
}