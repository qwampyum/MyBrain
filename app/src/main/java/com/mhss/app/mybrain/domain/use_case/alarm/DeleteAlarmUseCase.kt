package com.mhss.app.mybrain.domain.use_case.alarm

import com.mhss.app.mybrain.domain.repository.AlarmRepository
import com.mhss.app.mybrain.domain.repository.AlarmScheduler
import org.koin.core.annotation.Single

@Single
class DeleteAlarmUseCase(
    private val alarmRepository: AlarmRepository,
    private val alarmScheduler: AlarmScheduler
) {
    suspend operator fun invoke(alarmId: Int) {
        alarmScheduler.cancelAlarm(alarmId)
        alarmRepository.deleteAlarm(alarmId)
    }
}