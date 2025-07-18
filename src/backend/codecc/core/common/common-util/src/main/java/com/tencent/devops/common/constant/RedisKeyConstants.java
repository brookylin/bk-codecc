/*
 * Tencent is pleased to support the open source community by making BK-CODECC 蓝鲸代码检查平台 available.
 *
 * Copyright (C) 2019 Tencent.  All rights reserved.
 *
 * BK-CODECC 蓝鲸代码检查平台 is licensed under the MIT license.
 *
 * A copy of the MIT License is included in this file.
 *
 *
 * Terms of the MIT License:
 * ---------------------------------------------------
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN
 * NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.tencent.devops.common.constant;

/**
 * redis数据库的关键字常量，关键字统一使用大写（便于和字段名区分开来）
 *
 * @version V1.0
 * @date 2019/5/6
 */
public interface RedisKeyConstants {

    /**
     * 工具的顺序表
     */
    String KEY_TOOL_ORDER = "TOOL_ORDER";

    /**
     * 语言排序
     */
    String KEY_LANG_ORDER = "LANG_ORDER";

    /**
     * 工具信息表
     */
    String PREFIX_TOOL = "TOOL:";

    /**
     * 工具信息表的工具模型字段，
     * 工具模型：LINT、COMPILE、TSCLUA、CCN、DUPC，决定了工具的接入、告警、报表的处理及展示类型
     */
    String FILED_PATTERN = "pattern";

    /**
     * 任务注册自增序列
     */
    String CODECC_TASK_ID = "CodeCCTaskId";

    /**
     * 工具的扫描分析的自增序列key，每个项目的每个工具都有一个分析自增序号，格式：
     * ANALYSIS_SERIAL:taskId:toolName
     */
    String PREFIX_ANALYSIS_SERIAL = "ANALYSIS_SERIAL:";

    /**
     * 工具的扫描分析的版本号的key前缀，项目工具每次分析都有一个版本，用于区分一个方法是哪个版本扫描出来的，根据版本号来判断是否修复，格式：
     * ANALYSIS_VERSION:taskId:toolName
     */
    String PREFIX_ANALYSIS_VERSION = "ANALYSIS_VERSION:";

    /**
     * 通过蓝盾codecc服务建立的codecc任务的额外信息
     */
    String BLUE_SHIELD_PROJECT_EXTRA_INFO = "BLUE_SHIELD_PROJECT_EXTRA_INFO";

    /**
     * 间隔标识符 :
     */
    String INTERVAL_FLAG = ":";

    /**
     * 操作记录消息映射,基础数据具体内容如下：
     * 1.注册工具功能FUNC_REGISTER_TOOL：{0}添加工具{1}, {0} registered tools {1}
     * 2.修改任务信息功能FUNC_TASK_INFO：{0}修改任务信息, {0} modified task information
     * 3.停用启用任务功能FUNC_TASK_SWITCH：{0}修改任务状态, {0} switched task status
     * 4.触发分析功能FUNC_TRIGGER_ANALYSIS：{0}触发立即分析, {0} triggered immediate analysis
     * 5.切换工具状态FUNC_TOOL_SWITCH: {0}修改工具状态, {0} switched tool status
     * 6.修改扫描触发定时间FUNC_SCAN_SCHEDULE: {0}修改扫描触发时间, {0} modified scan schedule
     * 7.操作屏蔽路径的时间FUNC_FILTER_PATH: {0}修改屏蔽路径, {0} modified filtered path
     * 8.作者批量转换FUNC_DEFECT_MANAGE:{0}进行{1}工具的批量作者转换,原作者清单：{2},现作者清单：{3}, {0} batch transfer authors for tool {1},
     * previous author list: {2}, current author list: {3}
     * 9.任务代码库信息更新FUNC_CODE_REPOSITORY:{0}更新任务代码库信息,{0} updated task repository information
     */
    String PREFIX_OPERATION_HISTORY_MSG = "OPERATION_HISTORY_MSG:";

    /**
     * 操作类型
     */
    String GLOBAL_PREFIX_OPERATION_TYPE = "GLOBAL_OPERATION_TYPE";

    /**
     * 规则包国际化规则
     * KEY: CHECKER_PACKAGE_MSG
     */
    String GLOBAL_CHECKER_PACKAGE_MSG = "GLOBAL_CHECKER_PACKAGE_MSG";

    /**
     * 数据报表日期国际化KEY
     */
    String GLOBAL_DATA_REPORT_DATE = "GLOBAL_DATA_REPORT_DATE";

    /**
     * 工具描述国际化KEY
     */
    String GLOBAL_TOOL_DESCRIPTION = "GLOBAL_TOOL_DESCRIPTION";

    /**
     * 工具参数标签国际化KEY
     */
    String GLOBAL_TOOL_PARAMS_LABEL_NAME = "GLOBAL_TOOL_PARAMS_LABEL_NAME";

    /**
     * 工具参数提示国际化KEY
     */
    String GLOBAL_TOOL_PARAMS_TIPS = "GLOBAL_TOOL_PARAMS_TIPS";

    /**
     * 规则描述国际化KEY
     */
    String GLOBAL_CHECKER_DESC = "GLOBAL_CHECKER_DESC";


    String BK_JOB_CLUSTER_RECORD = "BK_JOB_CLUSTER_RECORD:";

    /**
     * 告警统计临时存放key
     */
    String PREFIX_TMP_STATISTIC = "TMP_STATISTIC:";

    /**
     * 告警规则统计临时存放key
     */
    String PREFIX_CHECKER_TMP_STATISTIC = "TMP_CHECKER_STATISTIC:";

    /**
     * 告警规则统计临时存放key
     */
    String PREFIX_CHECKER_SUMMARY_TMP_STATISTIC = "TMP_CHECKER_SUMMARY_STATISTIC:";

    /**
     * 分析机器集群
     */
    String KEY_ANALYZE_HOST = "ANALYZE_HOST";

    /**
     * 分析机器集群表锁
     */
    String LOCK_HOST_POOL = "LOCK_HOST_POOL";

    /**
     * 分析机器集群表锁，给开源扫描的
     */
    String LOCK_HOST_POOL_OPENSOURCE = "LOCK_HOST_POOL_OPENSOURCE";

    /**
     * 调度分析开关：true-开（正常调度分析），false-关（停止调度分析）
     */
    String DISPATCH_FLAG = "DISPATCH_FLAG";

    /**
     * 所有部门信息的key
     */
    String KEY_DEPT_INFOS = "DEPT_INFOS";

    /**
     * 所有部门树的key
     */
    String KEY_DEPT_TREE = "DEPT_TREE";

    /**
     * 仅保存BG、业务线、部门层级
     */
    String KEY_BG_TO_DEPT_TREE = "BG_TO_DEPT_TREE";

    /**
     * 保存每个组织架构的类型id
     */
    String KEY_DEPT_TYPE_ID = "KEY_DEPT_TYPE_ID";

    /**
     * 保存每个组织的父组织id
     */
    String KEY_DEPT_PARENT_ID = "KEY_DEPT_PARENT_ID";

    /**
     * bg管理员清单
     */
    String KEY_USER_BG_ADMIN = "USER_BG_ADMIN";


    /**
     * 任务和bg映射
     */
    String KEY_TASK_BG_MAPPING = "TASK_BG_MAPPING";


    /**
     * 告警上报状态
     */
    String KEY_REPORT_DEFECT = "KEY_REPORT_DEFECT";

    /**
     * 分析机器集群
     */
    String KEY_FILE_INFO = "FILE_INFO";

    /**
     * lint告警表迁移标志: MIGRATION_FLAG:taskId:toolName
     */
    String KEY_MIGRATION_FLAG = "MIGRATION_FLAG:";

    /**
     * 任务工具告警的自增序列key
     */
    String PREFIX_DEFECT_SEQUENCE = "DEFECT_SEQUENCE:";

    /**
     * 以task维度记录信息，用于websocket精准推送
     */
    String TASK_WEBSOCKET_SESSION_PREFIX = "TASK_WEBSOCKET_SESSION:";

    /**
     * task维度度量信息计算
     */
    String TASK_CODE_SCORING = "TASK_CODE_SCORING:";

    /**
     * 一个蓝盾项目的并发分析数
     */
    String PROJ_CONCURRENT_ANALYZE_COUNT = "PROJ_CONCURRENT_ANALYZE_COUNT";

    /**
     * 一个蓝盾项目的在等待队列的任务数
     */
    String PROJ_QUEUE_ANALYZE_COUNT = "PROJ_QUEUE_ANALYZE_COUNT";

    /**
     * 规则告警数统计时间
     */
    String CHECKER_DEFECT_STAT_TIME = "CHECKER_DEFECT_STAT_TIME";

    /**
     * 规则误报率统计时间
     */
    String CHECKER_DEFECT_STAT_IGNORE_TIME = "CHECKER_DEFECT_STAT_IGNORE_TIME";

    /**
     * 统计每天活跃任务数
     */
    String PREFIX_ACTIVE_TASK = "ACTIVE_TASK:";

    /**
     * 统计每天活跃工具数
     * 已改为从 PREFIX_ANALYZE_FAIL_COUNT + PREFIX_ANALYZE_SUCC_COUNT中获取
     */
    @Deprecated
    String PREFIX_ACTIVE_TOOL = "ACTIVE_TOOL:";

    /**
     * 统计工具分析失败次数
     */
    String PREFIX_ANALYZE_FAIL_COUNT = "ANALYZE_FAIL_COUNT:";

    /**
     * 统计工具成功失败次数
     */
    String PREFIX_ANALYZE_SUCC_COUNT = "ANALYZE_SUCC_COUNT:";

    /**
     * TOOL_BUILD_ID_SET:taskId:tool
     */
    String PREDIX_TOOL_BUILD_ID_SET = "TOOL_BUILD_ID_SET:";

    /**
     * 工具类型维度告警聚类
     */
    String TOOL_FINISH_CONFIRM_LOCK = "TOOL_FINISH_CONFIRM_LOCK";

    /**
     * 工具执行完成之后的确认队列
     */
    String TOOL_FINISH_CONFIRM = "TOOL_FINISH_CONFIRM";

    /**
     * 统计代码行
     */
    String CODE_LINE_STAT = "CODE_LINE_STAT:";

    /**
     * 记录工具成功分析的耗时
     */
    String PREFIX_ANALYZE_SUCC_ELAPSE_TIME = "ANALYZE_SUCC_ELAPSE_TIME:";

    /**
     * 按是否超快增量记录工具分析成功次数
     */
    String PREFIX_ANALYZE_SUCC_TOOL = "ANALYZE_SUCC_TOOL:";

    /**
     * 按是否超快增量记录工具分析失败次数
     */
    String PREFIX_ANALYZE_FAIL_TOOL = "ANALYZE_FAIL_TOOL:";

    /**
     * 腾讯代码规范各语言及计算系数
     */
    String STANDARD_LANG = "TENCENT_STANDARD_SUPPORT_LANG";

    /**
     * 按维度统计告警数文件导出标识
     */
    String DIMENSION_FILE_EXPORT_FLAG = "DIMENSION_FILE_EXPORT_FLAG";

    /**
     * 标识文件是否生成
     */
    String DIMENSION_FILE_FLAG = "DIMENSION_FILE_FLAG:";

    /**
     * 记录文件名
     */
    String DIMENSION_FILE_NAME = "DIMENSION_FILE_NAME";

    /**
     * BG管理员:gongfeng:rtx set
     */
    String PREFIX_BG_ADMIN = "BG_ADMIN:";

    /**
     * CodCC当前周的活跃用户
     */
    String USER_LOG_WEEK_RETAIN = "USER_LOG_WEEK_RETAIN:";

    /**
     * CodCC当前月的活跃用户
     */
    String USER_LOG_MONTH_RETAIN = "USER_LOG_MONTH_RETAIN:";

    /**
     * 记录单个工具一天覆盖的代码库清单
     */
    String TOOL_COVER_CODE_REPO_DAILY = "TOOL_COVER_CODE_REPO_DAILY:";

    /**
     * 记录单个工具一天新增的代码库清单
     */
    String TOOL_NEWADD_CODE_REPO_DAILY = "TOOL_NEWADD_CODE_REPO_DAILY:";

    /**
     * PRECI当前周的活跃用户
     */
    String PRECI_USER_LOG_WEEK_RETAIN = "PRECI_USER_LOG_WEEK_RETAIN:";

    /**
     * PRECI当前月的活跃用户
     */
    String PRECI_USER_LOG_MONTH_RETAIN = "PRECI_USER_LOG_MONTH_RETAIN:";

    /**
     * coverity/klocwork分析任务的分析服务器缓存
     */
    String ANALYZE_HOST_CACHE = "ANALYZE_HOST_CACHE";

    /**
     * commit到platform的并发锁
     */
    String CONCURRENT_COMMIT_LOCK = "CONCURRENT_COMMIT_LOCK";

    /**
     * 自定义redis队列的所有key的缓存
     */
    String CUSTOM_REDIS_MQ_KEYS = "CUSTOM_REDIS_MQ_KEYS";

    /**
     * 自定义redis队列key的锁，在新增队列且往队列里面写消息 或者 删除队列的时候 需要先加锁
     */
    String PREFIX_REDIS_MQ_KEY_LOCK = "REDIS_MQ_KEY_LOCK:";

    /**
     * commit platform的队列key前缀
     */
    String PREFIX_QUEUE_COMMIT_PLATFORM = "QUEUE_COMMIT_PLATFORM";

    String CLEAN_DATA_TASK_LIST = "CLEAN_DATA_TASK_LIST";

    /**
     * 处理人重新分配的缓存key判断
     */
    String IS_REALLOCATE = "reallocate";


    String PREFIX_MIGRATE_HISTORY_DEFECT = "MIGRATE_HISTORY_DEFECT:";

    /**
     * 批量开关
     */
    String REDIS_KEY_BATCH_MIGRATE_DEFECT_ENABLE =
            "LOCK_KEY:BATCH_MIGRATION_HISTORY_DEFECT_ENABLE";

    /**
     * 迁移开关
     */
    String REDIS_KEY_MIGRATE_DEFECT_ENABLE =
            "LOCK_KEY:MIGRATION_HISTORY_DEFECT_ENABLE";

    /**
     * 迁移下发间隔
     */
    String REDIS_KEY_MIGRATE_DEFECT_INTERVAL =
            "LOCK_KEY:MIGRATION_HISTORY_DEFECT_INTERVAL";

    /**
     * 回滚批量开关
     */
    String REDIS_KEY_BATCH_ROLLBACL_MIGRATE_DEFECT_ENABLE =
            "LOCK_KEY:BATCH_ROLLBACK_MIGRATION_HISTORY_DEFECT_ENABLE";

    /**
     * 回滚开关
     */
    String REDIS_KEY_ROLLBACL_MIGRATE_DEFECT_ENABLE =
            "LOCK_KEY:ROLLBACK_MIGRATION_HISTORY_DEFECT_ENABLE";

    /**
     * 调试的BuildId
     */
    String DEBUG_BUILD_ID_SET_KEY = "DEBUG_BUILD_ID_SET";


    /**
     * 提单黑名单
     */
    String COMMIT_DEFECT_TASK_ID_BLOCK_LIST = "COMMIT_DEFECT_TASK_ID_BLOCK_LIST";


    /**
     * 新增文件缓存密钥锁
     */
    String FILE_CACHE_SECRET_CHANGE_LOCK = "FILE_CACHE:SECRET_CHANGE_LOCK";


    /**
     * 新增文件缓存密钥锁
     */
    String FILE_CACHE_BUILD_INDEX_LOCK = "FILE_CACHE:BUILD_INDEX:";


    String GONGFENG_SCAN_CREATE_TASK_MIGRATE = "GONGFENG_SCAN_CREATE_TASK_MIGRATE";

    String NOTIFY_GONGFENG_SCAN_INTERVAL = "NOTIFY_GONGFENG_SCAN_INTERVAL";

    /**
     * 提单锁模式
     */
    String COMMIT_DEFECT_LOCK_IS_CLOSED = "COMMIT_DEFECT_LOCK_IS_CLOSED";

    /**
     * 数据表每日清理
     */
    String CLEAN_MONGO_DATA_STOP_FLAG = "CLEAN_MONGO_DATA_STOP_FLAG";

    /**
     * 规则数据统计【执行时长18小时】
     */
    String CHECKER_DEFECT_STAT_CONSUMER_STOP_FLAG = "CHECKER_DEFECT_STAT_CONSUMER_STOP_FLAG";

    /**
     * 工具侧上报代码仓库信息(/build/defects/repositories) 时，在 t_code_repo_info 表中创建新数据锁
     */
    String LOCK_T_CODE_REPO_INFO = "LOCK:T_CODE_REPO_INFO";
    /**
     * 任务失效工具告警处理
     */
    String TASK_INVALID_TOOL_DEFECT = "TASK_INVALID_TOOL_DEFECT";

    /**
     * 支持未触发补偿的任务类名
     */
    String BK_JOB_NO_TRIGGER_COMPENSATE_CLASS = "BK_JOB_NO_TRIGGER_COMPENSATE_CLASS";

    /**
     * 用于防止 RandomTestTaskStarterMQ 重复消费
     */
    String TEST_TASKS_STARTER_LOCK = "TEST_TASKS_STARTER_LOCK";

    /**
     * Open Scan 任务创建防重
     */
    String OPEN_SCAN_CREATE_TASK_LOCK = "OPEN_SCAN_CREATE_TASK_LOCK";

    /**
     * Github定时流水线超时时间
     */
    String GITHUB_TIMING_PIPELINE_TIMEOUT = "GITHUB_TIMING_PIPELINE_TIMEOUT:";

    /**
     * Github 使用的插件版本
     */
    String GITHUB_CODECC_PLUGIN_VERSION = "GITHUB_CODECC_PLUGIN_VERSION:";

    /**
     * 异步任务状态,"true":已执行完成，"false":执行中
     * ASYNC_TASK_STATUS:{key} - true/false
     */
    String ASYNC_TASK_STATUS = "ASYNC_TASK_STATUS:";

    /**
     * 异步任务得出的结果(不需持久化的数据，要配置过期时间)
     * ASYNC_TASK_RESULT:{key} - string
     */
    String ASYNC_TASK_RESULT = "ASYNC_TASK_RESULT:";

    /**
     * 在 工具上架-随机测试 的获取结果接口中用于限制 eligibleCount 字段只通知一次
     */
    String ELIGIBLE_TEST_TASKS_NOTIFY = "ELIGIBLE_TEST_TASKS_NOTIFY";

    /**
     * 缓存 工具上架 创建的工具名
     */
    String BK_TOOL_NAME_SET = "BK_TOOL_NAME_SET";

    /**
     * 缓存 工具上架 创建的工具名
     */
    String DEFECT_QUERY_KEY = "DEFECT_QUERY:";

    /**
     * 缓存 查询配置某工具的任务的分页索引
     */
    String TOOL_TASK_QUERY_CURSOR_KEY = "TOOL_TASK_QUERY_CURSOR";

    /**
     * 定时任务开关：同步TEG/AMS仓库信息,字符串 "true"为打开，否则为关闭
     */
    String SYNC_TEG_AMS_TASK_ENABLE = "SYNC_TEG_AMS_TASK_ENABLE";
}
