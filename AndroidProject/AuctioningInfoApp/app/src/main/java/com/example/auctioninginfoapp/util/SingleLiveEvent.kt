package com.example.freshauctionapp.util

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

/** SingleLiveEvent 클래스 선언
   - LiveData는 값이 변경될 때만 옵저버(Observer)에게 콜백을 전달하지만,
     예외적으로 옵저버가 inactive -> active 상태로 변경될 때도 콜백을 전달
     즉, LiveData 사용시 View의 재활성화 (start나 resume 상태로 재진입)가 되면서
     LiveData가 옵저버를 호출하여, 불필요한 Observer Event가 발생하는 경우 발생
     이를 방지하기 위해 LiveData를 상속하여 만들어낸 것이 SingleLiveEvent임

   - 즉 postValue나 setValue, call 등을 통하여 setValue 함수를 거쳐야만이
     Observer을 통하여 데이터를 전달 할 수 있으며,
     이는 Configuration Changed 등의 LifeCycleOwner의 재활성화 상태가 와도 원치 않는 이벤트가
     일어나는 것을 방지할 수 있도록 해줌
 */

class SingleLiveEvent<T> : MutableLiveData<T>() {

    /** AtomicBoolean 객체 생성
         - AtomicBoolean는 boolean 자료형을 갖고 있는 wrapping 클래스로
           멀티스레드 환경에서 동시성을 보장
         - isPending 객체는 setValue()로 새로운 이벤트를 받으면 true로 바뀌고
           그 이벤트가 실행되면 false로 돌아감 - 초기값은 false로 초기화
    */
    private val isPending = AtomicBoolean(false)

    /** View(Activity or Fragment 등 LifeCycleOwner)가 활성화 상태가 되거나
    setValue로 값이 바뀌었을 때 호출되는 observe 함수.
    - isPending 객체를 관찰하여 true 일 경우 false 로 바꾸고 이벤트 호출 알림
    */
    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {

        //observer가 여러개 들어와도 오직 1개만 처리하고자 하는 매커니즘
        super.observe(owner, Observer<T> { t ->
            /** CAS 알고리즘 수행
             - compareAndSet(expect, update)
               . isPending의 값이 expect 값과 동일(true)하면 isPending 값을 update 값(false)으로 바꾸고,
                 true를 리턴하고, if {observer.onChanged(t)}문을 실행하여 데이터를 변경함
               . 그렇지 않다면 데이터 변경은 없고 false 를 리턴
             - 아래의 setValue()를 통해서만 isPending값이 true로 바뀌기 때문에,
               Configuration Changed가 일어나도 isPending값은 false이기 때문에 데이터 변경 없음 */
            if (isPending.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        })
    }

    /** LiveData 값이 바뀌면 호출되는 함수로
     - LiveData 값이 변경되면 false였던 isPending이 true로 바뀌고, observe를 호출
       즉, setValue()에서 새로운 이벤트를 받으면 isPending 이 true로 바뀌고 observe 호출하여
       데이터를 변경  */
    @MainThread
    override fun setValue(t: T?) {
        isPending.set(true)
        super.setValue(t)
    }

    /** 데이터의 속성을 지정해주지 않아도 call만으로 setValue를 호출 가능
     *  - 변수(value) null 처리
     */
    @MainThread
    fun call() {
        value = null
    }
}
