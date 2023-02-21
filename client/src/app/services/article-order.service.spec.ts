import { TestBed } from '@angular/core/testing';

import { ArticleOrderService } from './article-order.service';

describe('ArticleOrderService', () => {
  let service: ArticleOrderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ArticleOrderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
