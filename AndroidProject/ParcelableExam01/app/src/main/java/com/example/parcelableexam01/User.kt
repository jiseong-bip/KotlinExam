package com.example.parcelableexam01

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

/** User 클래스 선언 및 Parcelable 인터페이스 구현
 *  - kotlin-parcelize 플러그인을 사용한 객체 직렬화
 * */
@Parcelize
data class User(var userId: String?, var userName: String?) : Parcelable {

    /** Parceler 인터페이스 구현
     *  - Parceler 인터페이스를 구현하여 Parceler 객체를 사용하려면
     *    User 클래스 내부의 companion 객체(object)로 선언하고 create() 및 write() 메서드를 재정의
     * */
    private companion object : Parceler<User> {
        /**create(): Parcel 객체에서 User 객체를 역직렬화(복원)하는 데 사용
         * - SecondActivity에서 User 객체를 복원할 때(intent.getParcelableExtra("USER", User::class.java)) 호출
         * */
        override fun create(parcel: Parcel): User {
            // Custom write implementation
            return User(parcel.readString(), parcel.readString())
        }

        /** write(): User 객체를 Parcel 객체로 직렬화하는 데 사용
         *  - MainActivity에서 startActivity() 실행할 때 호출
         * */
        override fun User.write(parcel: Parcel, flags: Int) {
            // Custom write implementation
            parcel.writeString(userId)
            parcel.writeString(userName)
        }
    }
}