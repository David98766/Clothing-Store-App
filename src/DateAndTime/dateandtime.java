/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DateAndTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.scene.control.Label;

/**
 *
 * @author adamm
 */
//This class is used on two stages in this project, the Manager Portal and the Customer portal.
//This class offers a clock that is constantly being updated to check if the time and date are correct.
// The Wristwatch method will work on any labels called lblTime or lblDate throughout the entire project, if it is referenced correctly.
public class dateandtime {
      public void Wristwatch(Label lblTime, Label lblDate) {
          //Formates the date to european style with the day of the week showing too
DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("E dd/MM/yyyy");
//shows hours and minutes as well as if it is am or pm
DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
//makes labels show current time
lblDate.setText(LocalDate.now().format(dateFormatter));
lblTime.setText(LocalTime.now().format(timeFormatter));
//calls the startTimer function
startTimer(timeFormatter, dateFormatter, lblTime, lblDate);
}
//The startTimer function will ensure that the time is constantly being updated
public void startTimer(DateTimeFormatter timeFormatter, DateTimeFormatter dateFormatter, Label lblTime, Label lblDate) {
    // the word "true" inside the brackets here makes this background function a Daemon thread, if you run the project without the word "true" in the brackets, it causes big problems
Timer timer = new Timer(true);
timer.scheduleAtFixedRate(new TimerTask() {
@Override
public void run() {
Platform.runLater(() -> {
LocalDateTime currentDateTime = LocalDateTime.now();

lblDate.setText(currentDateTime.format(dateFormatter));
lblTime.setText(currentDateTime.format(timeFormatter));
});
}
}, 0, 3000);//how often the timer updates
}
}
