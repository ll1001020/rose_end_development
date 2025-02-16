package com.rose.quartz.util;

import org.quartz.JobExecutionContext;
import com.rose.quartz.domain.SysJob;

/**
 * 定时任务处理（允许并发执行）
 *
 * @author rose
 *
 */
public class QuartzJobExecution extends AbstractQuartzJob
{
    @Override
    protected void doExecute(JobExecutionContext context, SysJob sysJob) throws Exception
    {
        JobInvokeUtil.invokeMethod(sysJob);
    }
}
