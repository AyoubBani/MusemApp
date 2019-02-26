/***
 Copyright (c) 2014 CommonsWare, LLC
 Licensed under the Apache License, Version 2.0 (the "License"); you may not
 use this file except in compliance with the License. You may obtain a copy
 of the License at http://www.apache.org/licenses/LICENSE-2.0. Unless required
 by applicable law or agreed to in writing, software distributed under the
 License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 OF ANY KIND, either express or implied. See the License for the specific
 language governing permissions and limitations under the License.

 From _The Busy Coder's Guide to Android Development_
 https://commonsware.com/Android
 */

package com.commonsware.android.video.browse;

class Video {
  int id;
  String uri;
  String mimeType;
  String title;

  Video(int id, String uri, String mimeType, String title) {
    this.id=id;
    this.uri=uri;
    this.mimeType=mimeType;
    this.title=title;
  }

  @Override
  public String toString() {
    return(title);
  }
}
