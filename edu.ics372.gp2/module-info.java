module edu.ics372.gp2 {
	requires javafx.graphics;
	requires javafx.controls;
	requires java.desktop;
	requires javafx.base;
	
	exports edu.ics372.gp2.displays to javafx.graphics;
	exports edu.ics372.gp2.start to javafx.graphics;
}