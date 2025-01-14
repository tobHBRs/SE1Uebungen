package org.hbrs.se1.ws24.tests.uebung10;

import org.hbrs.se1.ws24.exercises.uebung10.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class MyPrettyRectangleTest {

	private MyPrettyRectangle left;
	private MyPrettyRectangle middle;
	private MyPrettyRectangle right;
	private MyPrettyRectangle somewhere;

	/*
	 * Set-Up Methode ("BeforeEach"), die fuer alle Test-Methoden die Rechtecke gemaeß der Skizze definiert.
	 * Wird vor jeder Test-Methode ausgefuehrt.
	 *
	 */
	//
	@BeforeEach
	public void setUp() throws Exception {
		//
		//     +-----------+   +---+
		//     |         r |   | s |
		// +---+---+---+   |   |   |
		// | l |   | m |   |   |   |
		// |   |   +---+   |   |   |
		// |   |       |   |   |   |
		// +---+-------+   |   +---+
		//     |           |
		//     +-----------+
		//
		// Annahme: 1 Einheit = 1cm
		// MyPrettyRectangle-Konstruktor: MyPrettyRectangle(x1,y1,x2,y2)
		// x1,y1: Punkt links unten
		// x2,y2: Punkt rechts oben

		left = new MyPrettyRectangle(0.0, 1.0, 3.0, 3.0); // l
		middle = new MyPrettyRectangle(2.0, 2.0, 3.0, 3.0); // m
		right = new MyPrettyRectangle(1.0, 0.0, 4.0, 4.0);  // r
		somewhere = new MyPrettyRectangle(5.0, 1.0, 6.0, 4.0); // s

	}

	/*
	 * Methode zum Testen einer Methode der Klasse MyPrettyRectangle, welche prueft, ob ein Rechteck
	 * ein anderes Rechteck vollstaendig enthaelt. Bitte geben Sie einen vollständigen Test an!
	 * (Ergebnis: boolean Wert)
	 *
	 */
	@Test
	public void testContains() {
		// Tests für contains()
		assertTrue(right.contains(middle)); // right enthält middle
		assertTrue(right.contains(right));  // Ein Rechteck enthält sich selbst
		assertFalse(left.contains(right)); // left enthält nicht right
		assertFalse(middle.contains(left)); // middle enthält nicht left
		assertFalse(somewhere.contains(right)); // somewhere enthält nicht right
	}

	/*
	 * Methode zum Testen einer Methode der Kasse MyPrettyRectangle, welche den Mittelpunkt eines Rechtecks berechnet
	 * (Ergebnis: ein Punkt in einem Koordinatensystem)
	 *
	 */
	@Test
	public void testGetCenter() {
		// Tests für getCenter()
		assertEquals(new MyPoint(1.5, 2.0), left.getCenter());
		assertEquals(new MyPoint(2.5, 2.0), right.getCenter());
		assertEquals(new MyPoint(2.5, 2.5), middle.getCenter());
		assertEquals(new MyPoint(5.5, 2.5), somewhere.getCenter());
	}

	/*
	 * Methode zum Testen einer Methode der Klasse MyPrettyRectangle, welche die Flaeche eines Rechtecks berechnet
	 * (Ergebnis: Wert in Quadratzentimeter, cm2)
	 *
	 */

	@Test
	public void testGetArea() {
		// Tests für getArea()
		assertEquals(6.0, left.getArea(), 0.0001);
		assertEquals(1.0, middle.getArea(), 0.0001);
		assertEquals(12.0, right.getArea(), 0.0001);
		assertEquals(3.0, somewhere.getArea(), 0.0001);
	}



	/*
	 * Methode zum Testen einer Methode der Klasse MyPrettyRectangle, welche den Umfang eines Rechtecks berechnet
	 * (Ergebnis: Wert in Zentimeter, cm)
	 *
	 */
	@Test
	public void testGetPerimeter() {
		assertEquals(10.0, left.getPerimeter(),0.0001);
		assertEquals(4.0, middle.getPerimeter(), 0.0001); // Breite = 1, Höhe = 1
		assertEquals(14.0, right.getPerimeter(), 0.0001); // Breite = 3, Höhe = 4
		assertEquals(8.0, somewhere.getPerimeter(), 0.0001); // Breite = 1, Höhe = 3
	}





	/*
	 * Methode zum Testen der Objekt-Identitaet zwischen den MyPrettyRectangle-Objekten
	 *
	 */
	@Test
	public void testSameIdentity() {
		// Tests für Objekt-Identität
		MyPrettyRectangle other = left;

		// Tests für assertSame
		assertSame(left, other); // Gleiche Referenz
		assertNotSame(left, middle);
		assertNotSame(left, right);
		assertNotSame(left, somewhere);

		// Tests für equals
		assertTrue(left.equals(other)); // Gleiche Werte
		assertFalse(left.equals(middle));
		assertFalse(left.equals(right));
		assertFalse(left.equals(somewhere));

		// Weitere Tests
		assertTrue(left == other); // Identische Objekte
		assertFalse(left == middle); // Verschiedene Objekte
	}

	/*
	 * Methode zum Testen einer statischen Methode einer weiteren Klasse BoundingBoxFactory, die auf Basis eines Arrays von
	 * Rechtecken eine Bounding Box berechnet und zurueckliefert.
	 *
	 * Definition Bounding Box: Eine Bounding Box (deutsch: minimal umgebendes Rechteck, MUR) bezeichnet das
	 * kleinstmoegliche achsenparallele Rechteck, das eine vorgegebene Menge von Rechtecken umschliesst.
	 *
	 */

	@Test
	public void testGetBoundingBox() {
		MyPrettyRectangle[] rects = {
				new MyPrettyRectangle(2.0, 2.0, 3.0, 3.0), // middle
				new MyPrettyRectangle(1.0, 0.0, 4.0, 4.0), // right
				new MyPrettyRectangle(5.0, 1.0, 6.0, 4.0)  // somewhere
		};

		// Debug-Ausgabe für die Rechtecke
		for (int i = 0; i < rects.length; i++) {
			MyPrettyRectangle rect = rects[i];
			System.out.printf("Rechteck %d: x1=%.2f, y1=%.2f, x2=%.2f, y2=%.2f%n",
					i, rect.getX1(), rect.getY1(), rect.getX2(), rect.getY2());

			// Validierung der Koordinaten
			assertTrue(rect.getX1() < rect.getX2(), "x1 sollte kleiner als x2 sein");
			assertTrue(rect.getY1() < rect.getY2(), "y1 sollte kleiner als y2 sein");
		}

		// Teste Berechnung der Bounding Box
		MyPrettyRectangle boundingBox = BoundingBoxFactory.getBoundingBox(rects);
		assertNotNull(boundingBox);
		assertEquals(1.0, boundingBox.getX1(), 0.0001);
		assertEquals(0.0, boundingBox.getY1(), 0.0001);
		assertEquals(6.0, boundingBox.getX2(), 0.0001);
		assertEquals(4.0, boundingBox.getY2(), 0.0001);
	}

	@Test
	public void testGetBoundingBoxWithEmptyArray() {
		MyPrettyRectangle[] emptyRects = {}; // Leeres Array
		System.out.println("DEBUG: Test mit leerem Array gestartet.");

		// Rufe die Methode auf
		MyPrettyRectangle boundingBox = BoundingBoxFactory.getBoundingBox(emptyRects);

		// Debug-Ausgabe
		System.out.printf("DEBUG: Bounding Box zurückgegeben - x1=%.2f, y1=%.2f, x2=%.2f, y2=%.2f%n",
				boundingBox.getX1(), boundingBox.getY1(), boundingBox.getX2(), boundingBox.getY2());

		// Assertions
		assertNotNull(boundingBox);
		assertEquals(0.0, boundingBox.getX1(), 0.0001);
		assertEquals(0.0, boundingBox.getY1(), 0.0001);
		assertEquals(0.0, boundingBox.getX2(), 0.0001);
		assertEquals(0.0, boundingBox.getY2(), 0.0001);

		System.out.println("DEBUG: Test mit leerem Array erfolgreich abgeschlossen.");
	}

	@Test
	public void testGetBoundingBoxWithNullArray() {
		MyPrettyRectangle[] nullRects = null;
		System.out.println("DEBUG: Test mit null-Array gestartet.");

		// Rufe die Methode auf
		MyPrettyRectangle boundingBox = BoundingBoxFactory.getBoundingBox(nullRects);

		// Debug-Ausgabe
		System.out.printf("DEBUG: Bounding Box zurückgegeben - x1=%.2f, y1=%.2f, x2=%.2f, y2=%.2f%n",
				boundingBox.getX1(), boundingBox.getY1(), boundingBox.getX2(), boundingBox.getY2());

		// Assertions
		assertNotNull(boundingBox);
		assertEquals(0.0, boundingBox.getX1(), 0.0001);
		assertEquals(0.0, boundingBox.getY1(), 0.0001);
		assertEquals(0.0, boundingBox.getX2(), 0.0001);
		assertEquals(0.0, boundingBox.getY2(), 0.0001);

		System.out.println("DEBUG: Test mit null-Array erfolgreich abgeschlossen.");
	}









}