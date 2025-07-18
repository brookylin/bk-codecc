/*
 * Tencent is pleased to support the open source community by making BlueKing available.
 * Copyright (C) 2017-2018 Tencent. All rights reserved.
 * Licensed under the MIT License (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * http://opensource.org/licenses/MIT
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tencent.bk.codecc.task.service;

import com.tencent.bk.codecc.task.model.PipelineIdRelationshipEntity;

import java.time.LocalDate;
import java.util.List;

/**
 * 流水线id关联接口
 *
 * @version V1.0
 * @date 2020/10/28
 */
public interface PipelineIdRelationService {

    /**
     * 将记录更新为失败或者正在执行
     *
     * @param pipelineIdRelationshipEntity
     */
    void updateFailOrProcessRecord(PipelineIdRelationshipEntity pipelineIdRelationshipEntity);

    /**
     * 查询当日未成功的记录
     *
     * @return
     */
    List<PipelineIdRelationshipEntity> findAllFailOrProcessRecord();

    /**
     * 删除7天前的记录，保证流水表记录数处于适当范围
     */
    void deleteExpiredRecord();
}
