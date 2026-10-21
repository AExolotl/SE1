package org.hbrs.se1.ws26.exercises.uebung2;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    @Test
    void testContainer() throws ContainerException {

        Container container = new Container();

        Member member1 = new ConcreteMember(1);
        Member member2 = new ConcreteMember(2);

        // 1: Container ist anfangs leer
        assertEquals(0, container.size());

        // 2: Erstes Member hinzufügen
        container.addMember(member1);
        assertEquals(1, container.size());

        // 3: Zweites Member hinzufügen
        container.addMember(member2);
        assertEquals(2, container.size());

        // 4: ID des ersten Members kontrollieren
        assertEquals(1, member1.getID());

        // 5: ID des zweiten Members kontrollieren
        assertEquals(2, member2.getID());

        // 6: Doppelte ID muss eine Exception auslösen
        ContainerException exception = assertThrows(
                ContainerException.class,
                () -> container.addMember(new ConcreteMember(1))
        );
        assertEquals(
                "Das Member-Objekt mit der ID 1 ist bereits vorhanden!",
                exception.getMessage()
        );

        // 7: Nach dem fehlgeschlagenen Hinzufügen unverändert
        assertEquals(2, container.size());

        // 8: Erstes Member löschen
        assertTrue(
                container.deleteMember(1).contains("wurde gelöscht")
        );
        assertEquals(1, container.size());

        // 9: Bereits gelöschtes Member erneut löschen
        assertTrue(
                container.deleteMember(1).startsWith("Fehler")
        );
        assertEquals(1, container.size());

        // 10: Zweites Member löschen
        assertTrue(
                container.deleteMember(2).contains("wurde gelöscht")
        );
        assertEquals(0, container.size());

        // 11: Unbekannte ID löschen
        assertTrue(
                container.deleteMember(99).startsWith("Fehler")
        );
        assertEquals(0, container.size());

        // 12: toString() prüfen
        assertEquals("Member (ID = 1)", member1.toString());

        // 13: Wieder ein Member hinzufügen
        container.addMember(member1);
        assertEquals(1, container.size());
    }
}
