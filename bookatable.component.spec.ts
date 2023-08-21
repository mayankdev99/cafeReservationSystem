import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookatableComponent } from './bookatable.component';

describe('BookatableComponent', () => {
  let component: BookatableComponent;
  let fixture: ComponentFixture<BookatableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookatableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookatableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
