/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package jobs4u.base.infrastructure.persistence;

import jobs4u.base.applicationmanagement.repositories.JobApplicationRepository;
import jobs4u.base.candidatemanagement.repositories.CandidateRepository;
import jobs4u.base.clientusermanagement.repositories.ClientUserRepository;
import jobs4u.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import jobs4u.base.customermanagement.repositories.CustomerRepository;
import jobs4u.base.joboffermanagement.repositories.JobOfferRepository;
import jobs4u.base.notificationmanagement.repositories.NotificationRepository;
import jobs4u.base.pluginhandler.repositories.RegisteredPluginsRepository;
import jobs4u.base.rankingmanagement.repositories.RankingRepository;
import jobs4u.base.recruitmentprocessmanagement.repositories.RecruitmentProcessRepository;

/**
 * @author Paulo Gandra Sousa
 *
 */
public interface RepositoryFactory {

    /**
     * factory method to create a transactional context to use in the repositories
     *
     * @return
     */
    TransactionalContext newTransactionalContext();

    /**
     *
     * @param autoTx
     *            the transactional context to enrol
     * @return
     */
    UserRepository users(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    UserRepository users();

    /**
     *
     * @param autoTx
     *            the transactional context to enroll
     * @return
     */
    ClientUserRepository clientUsers(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    ClientUserRepository clientUsers();

    /**
     *
     * @param autoTx
     *            the transactional context to enroll
     * @return
     */
    SignupRequestRepository signupRequests(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    SignupRequestRepository signupRequests();

    /**
     *
     * @param autoTx
     *            the transactional context to enroll
     * @return
     */
    JobOfferRepository jobOffers(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    JobOfferRepository jobOffers();

    JobApplicationRepository jobApplications(TransactionalContext autoTx);

    RankingRepository rankings();

    RankingRepository rankings(TransactionalContext autoTx);

    JobApplicationRepository jobApplications();

    NotificationRepository notifications(TransactionalContext autoTx);

    NotificationRepository notifications();

    CustomerRepository customers(TransactionalContext autoTx);

    CustomerRepository customers();

    RegisteredPluginsRepository plugins(TransactionalContext autoTx);

    RegisteredPluginsRepository plugins();

    RecruitmentProcessRepository processes(TransactionalContext autoTx);

    RecruitmentProcessRepository processes();

    /**
	 *
	 * @param autoTx
	 *               the transactional context to enroll
	 * @return
	 */

	CandidateRepository candidate(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	CandidateRepository candidate();
}
