package com.example.intentexam03

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.intentexam03.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //바인딩 클래스 인스턴스 생성
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    //권한 요청을 확인하기 위한 상수
    private val CALL_REQUEST = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }
    //전화 걸기 버튼에 클릭 시 이벤트 처리
    fun init() {
        with(binding) {
            callBtn.setOnClickListener {
                callAction()
            }
        }
    }//end of init()

    /** 전화걸기 버튼 클릭 시 권한 확인 및 전화걸기 앱 실행 */
    fun callAction() {
        /** Android "CALL_PHONE" 권한이 있는지 확인(전화걸기 권한)
         ** 권한 설정 단계
        1. 매니페스트에 어떤 종류의 권한을 사용할 것인지 퍼미션 설정
        2. 실제 그 권한을 사용하는 Activity에서 권한 허용 여부를 판단하고, 권한 허용 요청
         *
         ** 권한이 있으면 전화걸기 앱을 실행시켜 전화를 걸고,
        권한이 없으면 사용자에게 "권한이 필요합니다"라는 메시지를 출력
         */

        /** 권한 요청은 Android 6.0(API 23)부터 사용하기 때문에 버전 Check
        - if()문은 권한이 허용되어 있지 않으면(!= PackageManager.PERMISSION_GRANTED) 실행
        . 권한이 없으면 "CALL_PHONE 권한이 필요합니다." 메시지 출력하고,
        ActivityCompat.requestPermissions()에 의해 권한 요청 다이얼로그가 표시됨
        . CALL_REQUEST: 한 화면에서 여러 종류의 권한 세트를 요청할 수 있으므로,
        어떤 권한 세트를 지정했는지를 확인하기 위한 임의의 상수
        . public static final int M = 23;
         */
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
            ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(this, "CALL_PHONE 권한이 필요합니다.", Toast.LENGTH_LONG).show()

            //권한 요청 다이얼로그가 표시
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.CALL_PHONE),
                CALL_REQUEST
            )
            return
        }

        /** 권한이 있는 경우 입력한 전화번호를 가져와서 phoneIntent를 생성하여 시스템에 전달
        - 전화 걸기 앱 실행
         * */

        /** 입력창에서 입력한 전화번호 가져오기 */
        val phoneNumber = Uri.parse("tel:" + binding.phoneNo.text.toString())

        /** 전화걸기 앱을 실행시키기 위한 암시적 인텐트 선언
        - Intent(Action, Data)
         */
        val phoneIntent = Intent(Intent.ACTION_CALL, phoneNumber)

        /** 전화 걸기 앱이 있는지 확인하여 있으면 해당 앱을 실행시켜 줄 것을 시스템에 요청 */
        if (phoneIntent.resolveActivity(packageManager) != null) {
            startActivity(phoneIntent)
        }
    }//end of callAction()

    /**
     * 권한 요청에 대한 응답을 하는 콜백
     *
     * @param requestCode 요청코드
     * @param permissions 사용자가 요청한 권한들
     * @param grantResults 권한에 대한 응답들(인덱스별로 매칭)
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode) {
            CALL_REQUEST -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "권한 승인", Toast.LENGTH_LONG).show()
                    callAction()
                } else {
                    Toast.makeText(this, "권한 거절", Toast.LENGTH_LONG).show()
                }
            }
        }
    }//end of onRequestPermissionsResult()
}