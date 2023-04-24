package com.example.myandroid.stream;

public class Video {
        private String videoName;
        private String videoPath;

        public Video(String videoName, String videoPath) {
            this.videoName = videoName;
            this.videoPath = videoPath;
        }

        public String getVideoName() {
            return videoName;
        }

        public void setVideoName(String videoName) {
            this.videoName = videoName;
        }

        public String getVideoPath() {
            return videoPath;
        }

        public void setVideoPath(String videoPath) {
            this.videoPath = videoPath;
        }
    }