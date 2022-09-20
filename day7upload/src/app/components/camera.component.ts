import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';

import { WebcamImage } from 'ngx-webcam';
import { CameraService } from '../services/camera.service';

@Component({
  selector: 'app-camera',
  templateUrl: './camera.component.html',
  styleUrls: ['./camera.component.css']
})
export class CameraComponent implements OnInit {

    width!: number
    captureImage = '/assets/placeholder.png'

    trigger = new Subject<void>();
    triggerObs = this.trigger.asObservable();

    constructor(private router: Router, private cameraSvc: CameraService) { }

    ngOnInit(): void { 
      this.width = Math.floor(window.innerWidth / 3)
    }

    capture() {
      console.info('>>> capture')
      this.trigger.next()
    }

    snapshot(img: WebcamImage) {
      console.info('>> img: ', img)
      this.captureImage = img.imageAsDataUrl
      this.cameraSvc.image = img.imageAsDataUrl
      this.router.navigate([ '/upload' ])
    }
    
}
