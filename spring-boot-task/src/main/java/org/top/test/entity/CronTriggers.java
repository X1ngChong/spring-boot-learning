package org.top.test.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author JXS
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CronTriggers {
    private String schedName;
    private String triggerName;
    private String triggerGroup;
    private String cronExpression;
    private String timeZoneId;
}
