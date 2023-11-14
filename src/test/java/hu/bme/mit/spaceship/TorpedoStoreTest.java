package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

  @Test
  void fire_Success(){
    // Arrange
    TorpedoStore store = new TorpedoStore(1);

    // Act
    boolean result = store.fire(1);

    // Assert
    assertEquals(true, result);
  }
  
  @Test
  void fire_fail(){
    // Arrange
    TorpedoStore store = new TorpedoStore(1, 1);

    // Act
    boolean result = store.fire(1);

    // Assert
    assertEquals(false, result);
  }

  @Test
  void fire_count(){
    // Arrange
    TorpedoStore store = new TorpedoStore(10);

    // Act
    store.fire(1);
    assertEquals(9, store.getTorpedoCount());
    store.fire(2);
    assertEquals(7, store.getTorpedoCount());
    store.fire(3);
    assertEquals(4, store.getTorpedoCount());
    store.fire(4);
    assertEquals(0, store.getTorpedoCount());
  }

  @Test
  void fire_exception(){
    // Arrange
    TorpedoStore store = new TorpedoStore(1);

    assertThrows(IllegalArgumentException.class, () -> store.fire(2) );
  }
}
