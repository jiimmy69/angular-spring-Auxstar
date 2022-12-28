import { ComponentFixture, TestBed } from '@angular/core/testing';
import { TachesListComponent } from './taches-list.component';



describe('tachesListComponent', () => {
  let component: TachesListComponent;
  let fixture: ComponentFixture<TachesListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TachesListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TachesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
