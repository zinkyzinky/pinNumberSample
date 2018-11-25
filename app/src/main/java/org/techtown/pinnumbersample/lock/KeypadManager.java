package org.techtown.pinnumbersample.lock;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.techtown.pinnumbersample.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KeypadManager {
    private final Context mContext;

    public KeypadManager(Context context) {
        mContext = context;
    }


    /**
     * 숫자 키패드 초기화
     */
    public void initNumberKeypad() {

        LinearLayout keypadContainer = ((Activity) mContext).findViewById(R.id.keypad_container);
        keypadContainer.removeAllViews();


        ViewGroup keypadView;
        keypadView = (ViewGroup) ((Activity) mContext).getLayoutInflater().inflate(R.layout.number_keypad, keypadContainer, false);

        List<Character> keypadNumbers = getKeypadNumbersArrayList();

        Random random = new Random();

        TextView keyButton = null;
        int randomIndex;
        Character numberString;

        LinearLayout keypadSubContainer;

        for (int i = 0; i < 10; i++) {

            switch (i) {
                case 0:
                    keypadSubContainer = (LinearLayout) keypadView.getChildAt(0);
                    keyButton = (TextView) keypadSubContainer.getChildAt(0);
                    break;

                case 1:
                    keypadSubContainer = (LinearLayout) keypadView.getChildAt(0);
                    keyButton = (TextView) keypadSubContainer.getChildAt(2);
                    break;


                case 2:
                    keypadSubContainer = (LinearLayout) keypadView.getChildAt(0);
                    keyButton = (TextView) keypadSubContainer.getChildAt(4);
                    break;
                case 3:
                    keypadSubContainer = (LinearLayout) keypadView.getChildAt(2);
                    keyButton = (TextView) keypadSubContainer.getChildAt(0);
                    break;
                case 4:
                    keypadSubContainer = (LinearLayout) keypadView.getChildAt(2);
                    keyButton = (TextView) keypadSubContainer.getChildAt(2);
                    break;
                case 5:
                    keypadSubContainer = (LinearLayout) keypadView.getChildAt(2);
                    keyButton = (TextView) keypadSubContainer.getChildAt(4);
                    break;
                case 6:
                    keypadSubContainer = (LinearLayout) keypadView.getChildAt(4);
                    keyButton = (TextView) keypadSubContainer.getChildAt(0);
                    break;
                case 7:
                    keypadSubContainer = (LinearLayout) keypadView.getChildAt(4);
                    keyButton = (TextView) keypadSubContainer.getChildAt(2);
                    break;
                case 8:
                    keypadSubContainer = (LinearLayout) keypadView.getChildAt(4);
                    keyButton = (TextView) keypadSubContainer.getChildAt(4);
                    break;

                case 9:
                    keypadSubContainer = (LinearLayout) keypadView.getChildAt(6);
                    keyButton = (TextView) keypadSubContainer.getChildAt(2);
                    break;

            }


            randomIndex = random.nextInt(keypadNumbers.size());
            numberString = keypadNumbers.get(randomIndex);
            keyButton.setText(String.valueOf(numberString));
            keyButton.setTag(numberString);
            keypadNumbers.remove(numberString);
        }

        keypadContainer.addView(keypadView);
    }


    /**
     * 키패드 숫자 ArrayList 생성
     *
     * @return
     */
    private List<Character> getKeypadNumbersArrayList() {
        List<Character> keypadNumbers = new ArrayList<>();
        keypadNumbers.add('0');
        keypadNumbers.add('1');
        keypadNumbers.add('2');
        keypadNumbers.add('3');
        keypadNumbers.add('4');
        keypadNumbers.add('5');
        keypadNumbers.add('6');
        keypadNumbers.add('7');
        keypadNumbers.add('8');
        keypadNumbers.add('9');
        return keypadNumbers;
    }



}
