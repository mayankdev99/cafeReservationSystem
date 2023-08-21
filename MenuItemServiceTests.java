package cafe;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import cafe.exception.ResourceNotFoundException;
import cafe.entity.MenuItem;
import cafe.repository.MenuItemRepository;
import cafe.service.MenuItemService;

@SpringBootTest
public class MenuItemServiceTests {

    private MenuItemService menuItemService;
    private MenuItemRepository menuItemRepository;

    @BeforeEach
    void setUp() {
        menuItemRepository = mock(MenuItemRepository.class);
        menuItemService = new MenuItemService(menuItemRepository);
    }

    @Test
    void testGetAllMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem());
        when(menuItemRepository.findAll()).thenReturn(menuItems);

        List<MenuItem> retrievedMenuItems = menuItemService.getAllMenuItems();

        assertNotNull(retrievedMenuItems);
        assertEquals(1, retrievedMenuItems.size());
    }

    @Test
    void testGetMenuItemByIdExistingId() {
        Long id = 1L;
        MenuItem menuItem = new MenuItem();
        menuItem.setId(id);
        when(menuItemRepository.findById(id)).thenReturn(Optional.of(menuItem));

        MenuItem retrievedMenuItem = menuItemService.getMenuItemById(id);

        assertNotNull(retrievedMenuItem);
        assertEquals(id, retrievedMenuItem.getId());
    }

    @Test
    void testGetMenuItemByIdNonExistingId() {
        Long id = 1L;
        when(menuItemRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> menuItemService.getMenuItemById(id));
    }

    @Test
    void testCreateMenuItem() {
        MenuItem menuItem = new MenuItem();
        menuItem.setId(1L);
        when(menuItemRepository.save(any(MenuItem.class))).thenReturn(menuItem);

        MenuItem createdMenuItem = menuItemService.createMenuItem(menuItem);

        assertNotNull(createdMenuItem);
        assertEquals(1L, createdMenuItem.getId());
    }

    @Test
    void testUpdateMenuItem() {
        Long id = 1L;
        MenuItem existingMenuItem = new MenuItem();
        existingMenuItem.setId(id);
        MenuItem updatedMenuItem = new MenuItem();
        updatedMenuItem.setId(id);
        updatedMenuItem.setMenuName("New Name");
        when(menuItemRepository.findById(id)).thenReturn(Optional.of(existingMenuItem));
        when(menuItemRepository.save(any(MenuItem.class))).thenReturn(updatedMenuItem);

        MenuItem result = menuItemService.updateMenuItem(id, updatedMenuItem);

        assertNotNull(result);
        assertEquals("New Name", result.getMenuName());
    }

    @Test
    void testUpdateMenuItemNonExistingId() {
        Long id = 1L;
        MenuItem updatedMenuItem = new MenuItem();
        updatedMenuItem.setId(id);
        updatedMenuItem.setMenuName("New Name");
        when(menuItemRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> menuItemService.updateMenuItem(id, updatedMenuItem));
    }

    @Test
    void testDeleteMenuItem() {
        Long id = 1L;
        doNothing().when(menuItemRepository).deleteById(id);

        assertDoesNotThrow(() -> menuItemService.deleteMenuItem(id));
    }
}
