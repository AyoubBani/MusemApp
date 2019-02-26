/*
 * Copyright (C) 2008 ZXing authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.zxing.client.android.result;

import com.google.zxing.client.android.R;
import com.google.zxing.client.result.EmailAddressParsedResult;
import com.google.zxing.client.result.ParsedResult;

import android.app.Activity;

/**
 * Handles email addresses.
 *
 * @author dswitkin@google.com (Daniel Switkin)
 */
public final class EmailAddressResultHandler extends ResultHandler {
  private static final int[] buttons = {
      R.string.button_email,
      R.string.button_add_contact
  };

  public EmailAddressResultHandler(Activity activity, ParsedResult result) {
    super(activity, result);
  }

  @Override
  public int getButtonCount() {
    return buttons.length;
  }

  @Override
  public int getButtonText(int index) {
    return buttons[index];
  }

  @Override
  public void handleButtonPress(int index) {
    EmailAddressParsedResult emailResult = (EmailAddressParsedResult) getResult();
   
    if(index==0){
   
        sendEmail(emailResult.getClass(),
                  emailResult.getClass(),
                  emailResult.getClass(),
                  emailResult.getSubject(),
                  emailResult.getBody());
        }
    if(index==1){
        //addEmailOnlyContact(emailResult.getClass(), null);
        }
    
  }

  private void sendEmail(Class<? extends EmailAddressParsedResult> class1,
		Class<? extends EmailAddressParsedResult> class2, Class<? extends EmailAddressParsedResult> class3,
		String subject, String body) {
	// TODO Auto-generated method stub
	
}

@Override
  public int getDisplayTitle() {
    return R.string.result_email_address;
  }
}
