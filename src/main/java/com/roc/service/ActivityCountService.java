package com.roc.service;

import com.roc.domain.Count;

public interface ActivityCountService {

    void updateNumber(Count count);

    void saveNumber(Count count);
}
