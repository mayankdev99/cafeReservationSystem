import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuTableComponent } from './menu-table.component';

describe('MenuTableComponent', () => {
  let component: MenuTableComponent;
  let fixture: ComponentFixture<MenuTableComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MenuTableComponent]
    });
    fixture = TestBed.createComponent(MenuTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
